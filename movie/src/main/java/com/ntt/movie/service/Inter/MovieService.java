package com.ntt.movie.service.Inter;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.MovieModel;
import com.ntt.movie.model.dto.MovieCreateRequestDTO;

public interface MovieService {
    MovieModel create(MovieCreateRequestDTO movieModel);
  
    List<MovieModel> getAll();
  
    Optional<MovieModel> getById(Long id);

    MovieModel updateById(Long id, MovieModel movieModel);

    void delete(Long id);
}
