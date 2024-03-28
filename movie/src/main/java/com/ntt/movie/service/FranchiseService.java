package com.ntt.movie.service;

import java.util.List;

import java.util.Optional;

import com.ntt.movie.model.FranchiseModel;

public interface FranchiseService {

    FranchiseModel create(FranchiseModel franchise);

    List<FranchiseModel> findAll();

    Optional<FranchiseModel> findById(Long id);
    
    FranchiseModel updateById(Long id, FranchiseModel franchise);

    void delete(Long id);
}
