package com.ntt.movie.service.Inter;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.MovieModel;

public interface MovieService {
    MovieModel create(MovieModel movieModel);
  
    List<MovieModel> getAll();
  
    Optional<MovieModel> getById(Long id);

    MovieModel updateById(Long id, MovieModel movieModel);

    void delete(Long id);
    
    // List<MovieModel> getByTitle(String title);

    // List<MovieModel> getByGenre(String genre);

    // List<MovieModel> getByDirector(String director);

    // List<MovieModel> getByStudio(String studio);

    // List<MovieModel> getByStreaming(String streaming);

    // List<MovieModel> getByRole(String role);

    // List<MovieModel> getByUser(String user);

}
