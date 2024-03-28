package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.MovieModel;
import com.ntt.movie.repository.MovieRepository;
import com.ntt.movie.service.Inter.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @SuppressWarnings("null")
    @Override
    public MovieModel create(MovieModel movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<MovieModel> getAll() {
        return movieRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<MovieModel> getById(Long id) {
        return Optional.ofNullable(movieRepository.findById(id).orElse(null));
    }

    @SuppressWarnings("null")
    @Override
    public MovieModel updateById(Long id, MovieModel movie) {
        MovieModel movieToUpdate = movieRepository.findById(id).orElse(null);

        movieToUpdate.setTitle(movie.getTitle());
        
        return movieRepository.save(movieToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
