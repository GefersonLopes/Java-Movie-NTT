package com.ntt.movie.service.Inter;

import java.util.List;

import com.ntt.movie.model.DirectorModel;

public interface DirectorService {
    DirectorModel create(DirectorModel actor);

    List<DirectorModel> getAll();

    DirectorModel getById(Long id);

    DirectorModel updateById(Long id, DirectorModel actor);
    
    void delete(Long id);
}
