package com.ntt.movie.service.Inter;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.ActorModel;

public interface ActorService {
    ActorModel create(ActorModel actor);

    List<ActorModel> getAll();

    Optional<ActorModel> getById(Long id);

    ActorModel updateById(Long id, ActorModel actor);
    
    void delete(Long id);
}
