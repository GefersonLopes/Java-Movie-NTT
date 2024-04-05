package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.AddressModel;
import com.ntt.movie.repository.AddressRepository;
import com.ntt.movie.service.Inter.AddressService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressModel create(@Valid @NotNull AddressModel address) {
        return addressRepository.save(address);
    }

    @Override
    public List<AddressModel> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<AddressModel> getById(@Valid @NotNull Long id) {
        return Optional.ofNullable(addressRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Address not found with id: " + id)));
    }

    @Override
    public AddressModel updateById(Long id, AddressModel address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(@Valid @NotNull Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Object getViaCep(String zipCode) {
        String viaCepUrl = "https://viacep.com.br/ws/" + zipCode + "/json/";
        return restTemplate.getForObject(viaCepUrl, Object.class);
    }
}
