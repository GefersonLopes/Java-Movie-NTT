package com.ntt.movie.service.Inter;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.AddressModel;

public interface AddressService {
  AddressModel create(AddressModel address);

  List<AddressModel> getAll();

  Optional<AddressModel> getById(Long id);

  AddressModel updateById(Long id, AddressModel address);

  void delete(Long id);

  Object getViaCep(String zipCode);
}
