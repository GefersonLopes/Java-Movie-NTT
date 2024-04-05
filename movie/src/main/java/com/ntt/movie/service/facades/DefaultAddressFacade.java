package com.ntt.movie.service.facades;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ntt.movie.config.ModelMapperConfig;
import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.model.AddressModel;
import com.ntt.movie.model.UserModel;
import com.ntt.movie.model.dto.AddressDTO;
import com.ntt.movie.model.dto.AddressRequestDTO;
import com.ntt.movie.repository.AddressRepository;
import com.ntt.movie.service.Inter.AddressService;
import com.ntt.movie.service.Inter.UserService;

@Service
public class DefaultAddressFacade implements AddressFacade {
  
  private final AddressService addressesService;
  private final UserService userService;
  private final AddressRepository addressRepository;

  public DefaultAddressFacade(
    AddressService addressesService,
    UserService userService,
    AddressRepository addressRepository
    ) {
    this.addressesService = addressesService;
    this.userService = userService;
    this.addressRepository = addressRepository;
  }
  
  @Override
  public AddressDTO create(Long user_id, String zipCode) {
    if(user_id == null) {
        throw new ExceptionBadRequest("Users is required");
    }

    if(zipCode == null || zipCode.isEmpty()) {
        throw new ExceptionBadRequest("Zip code is required");
    }
    
    AddressModel addressModel = new AddressModel();
    Object response = addressesService.getViaCep(zipCode);

    if(response == null) {
        throw new ExceptionBadRequest("Zip code not found");
    }

    UserModel user = userService.getById(user_id).get();

    if(response instanceof LinkedHashMap) {
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, String> responseMap = (LinkedHashMap<String, String>) response;
        addressModel.setCity(responseMap.get("localidade"));
        addressModel.setState(responseMap.get("uf"));
        addressModel.setZipCode(responseMap.get("cep"));
        addressModel.setStreet(responseMap.get("logradouro"));
        addressModel.setUser(user);
    }

    AddressDTO address = new AddressDTO();
    populateAddress(address, addressModel);
    // addressesService.create(addressModel);
    try {
      addressRepository.save(addressModel);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return address;
  }

  @Override
  public List<AddressDTO> getAll() {
    List<AddressModel> addresses = addressesService.getAll();
    List<AddressDTO> addressesDTO = new ArrayList<>();

    for (AddressModel user : addresses) {
        AddressDTO userDTO = new AddressDTO();
        populateAddress(userDTO, user);
        addressesDTO.add(userDTO);
    }

    return addressesDTO;
  }

  @Override
  public Optional<AddressDTO> getById(Long id) {
    Optional<AddressModel> addressRepo = addressesService.getById(id);
    AddressModel address = addressRepo.get();

    ModelMapperConfig mapperConfig = new ModelMapperConfig();
    AddressDTO addressDTO = mapperConfig.modelMapper().map(address, AddressDTO.class);
    populateAddress(addressDTO, address);

    Optional<AddressDTO> addressDTOOptional = Optional.of(addressDTO);
    return addressDTOOptional;
  }

  @Override
  public AddressDTO updateById(Long id, AddressRequestDTO addressRequestDTO) {
    Optional<AddressModel> addressModel = addressesService.getById(id);
    AddressModel addressToUpdate = addressModel.get();

    if (addressRequestDTO.getZipCode() == null || addressRequestDTO.getZipCode().isEmpty()) {
        addressRequestDTO.setZipCode(addressToUpdate.getZipCode());
    }

    if (addressRequestDTO.getUser_id() == null) {
        addressRequestDTO.setUser_id(id);
    }

    Object response = addressesService.getViaCep(addressRequestDTO.getZipCode());

    if(response == null) {
        throw new ExceptionBadRequest("Zip code not found");
    }

    if(response instanceof LinkedHashMap) {
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, String> responseMap = (LinkedHashMap<String, String>) response;
        addressToUpdate.setCity(responseMap.get("localidade"));
        addressToUpdate.setState(responseMap.get("uf"));
        addressToUpdate.setZipCode(responseMap.get("cep"));
        addressToUpdate.setStreet(responseMap.get("logradouro"));
    }

    UserModel user = userService.getById(addressRequestDTO.getUser_id()).get();
    addressToUpdate.setUser(user);

    AddressDTO address = new AddressDTO();

    populateAddress(address, addressToUpdate);
    addressesService.updateById(id, addressToUpdate);  

    return address;
  }

  @Override
  public void delete(Long id) {
    Optional<AddressModel> addressRepo = addressesService.getById(id);
    AddressModel addressToDelete = addressRepo.get();
    addressesService.delete(addressToDelete.getId());
  }

  private void populateAddress(AddressDTO address, AddressModel addressModel) {
    address.setId(addressModel.getId());
    address.setCity(addressModel.getCity());
    address.setState(addressModel.getState());
    address.setZipCode(addressModel.getZipCode());
    address.setStreet(addressModel.getStreet());
    address.setUser(addressModel.getUser());
  } 
}
