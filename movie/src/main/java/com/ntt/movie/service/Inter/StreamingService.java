package com.ntt.movie.service.Inter;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.StreamingModel;

public interface StreamingService {
    StreamingModel create(StreamingModel streaming);

    List<StreamingModel> getAll();

    Optional<StreamingModel> getById(Long id);

    StreamingModel updateById(Long id, StreamingModel streaming);
    
    void delete(Long id);
}
