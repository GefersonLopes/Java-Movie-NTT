package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.AddressModel;

public interface AddressRepository extends JpaRepository<AddressModel, Long>{}