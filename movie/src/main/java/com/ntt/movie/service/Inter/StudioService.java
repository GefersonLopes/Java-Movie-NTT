package com.ntt.movie.service.Inter;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.StudioModel;

public interface StudioService {
    StudioModel create(StudioModel studio);

    List<StudioModel> getAll();

    Optional<StudioModel> getById(Long id);

    StudioModel updateById(Long id, StudioModel studio);
    
    void delete(Long id);
}
