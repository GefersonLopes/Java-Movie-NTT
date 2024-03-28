package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.DirectorModel;

public interface DirectorService {
    DirectorModel create(DirectorModel actor);

    List<DirectorModel> getAll();

    DirectorModel getById(Long id);

    Optional<DirectorModel> updateById(Long id, DirectorModel actor);
    
    void delete(Long id);
}
