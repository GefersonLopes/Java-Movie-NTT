package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.dto.AddressDTO;
import com.ntt.movie.model.dto.AddressRequestDTO;
import com.ntt.movie.service.facades.AddressFacade;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressFacade addressFacade;

    @PostMapping
    public ResponseEntity<AddressDTO> create(@RequestBody AddressRequestDTO address) {
        return ResponseEntity.ok(addressFacade.create(address.getUser_id(), address.getZipCode()));
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAll() {
        return ResponseEntity.ok(addressFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(addressFacade.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AddressDTO> updateById(@PathVariable Long id, @RequestBody AddressRequestDTO address) {
        return ResponseEntity.ok(addressFacade.updateById(id, address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        addressFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
