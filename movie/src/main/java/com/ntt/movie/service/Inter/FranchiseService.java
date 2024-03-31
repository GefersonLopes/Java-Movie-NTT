package com.ntt.movie.service.Inter;

import java.util.List;

import java.util.Optional;

import com.ntt.movie.model.FranchiseModel;
import com.ntt.movie.model.dto.FranchiseCreateRequestDTO;
import com.ntt.movie.model.dto.MovieToFranchiseDTO;

public interface FranchiseService {

    FranchiseModel create(FranchiseCreateRequestDTO franchise);

    List<FranchiseModel> getAll();

    Optional<FranchiseModel> getById(Long id);
    
    FranchiseModel updateById(Long id, FranchiseCreateRequestDTO franchise);

    void delete(Long id);

    FranchiseModel setMovies(MovieToFranchiseDTO movieToFranchise);
}
