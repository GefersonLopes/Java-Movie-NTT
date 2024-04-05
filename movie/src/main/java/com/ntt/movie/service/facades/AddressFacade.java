package com.ntt.movie.service.facades;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.dto.AddressDTO;
import com.ntt.movie.model.dto.AddressRequestDTO;

public interface AddressFacade {
    AddressDTO create(Long id, String zipCode);

    List<AddressDTO> getAll();

    Optional<AddressDTO> getById(Long id);

    AddressDTO updateById(Long id, AddressRequestDTO address);

    void delete(Long id);
}
