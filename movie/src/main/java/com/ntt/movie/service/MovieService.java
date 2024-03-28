package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.MovieModel;

public interface MovieService {
    MovieModel create(MovieModel movieModel);
  
    List<MovieModel> findAll();
  
    Optional<MovieModel> findById(Long id);

    MovieModel updateById(Long id, MovieModel movieModel);

    void deleteById(Long id);
    
    List<MovieModel> findByTitle(String title);

    List<MovieModel> findByGenre(String genre);

    List<MovieModel> findByDirector(String director);

    List<MovieModel> findByStudio(String studio);

    List<MovieModel> findByStreaming(String streaming);

    List<MovieModel> findByRole(String role);

    List<MovieModel> findByUser(String user);

    List<MovieModel> findByGenreAndDirector(String genre, String director);

}
