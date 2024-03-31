package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.*;
import com.ntt.movie.model.dto.MovieCreateRequestDTO;
import com.ntt.movie.repository.*;
import com.ntt.movie.service.Inter.MovieService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private StreamingRepository streamingRepository;

    @SuppressWarnings("null")
    @Override
    @Transactional
    public MovieModel create(@Valid @NotNull MovieCreateRequestDTO request) {

        if (request.getTitle() == null || request.getTitle().isEmpty()) {
            throw new ExceptionBadRequest("Title not allowed.");
        }

        GenreModel genre = genreRepository.findById(request.getGenre_id()).orElseThrow(() -> new ExceptionNotFound("Genre not found with id: " + request.getGenre_id()));
        StudioModel studio = studioRepository.findById(request.getStudio_id()).orElseThrow(() -> new ExceptionNotFound("Studio not found with id: " + request.getStudio_id()));
        FranchiseModel franchise = franchiseRepository.findById(request.getFranchise_id()).orElseThrow(() -> new ExceptionNotFound("Franchise not found with id: " + request.getFranchise_id()));
        StreamingModel streaming = streamingRepository.findById(request.getStreaming_id()).orElseThrow(() -> new ExceptionNotFound("Streaming not found with id: " + request.getStreaming_id()));

        MovieModel movie = new MovieModel();
        movie.setTitle(request.getTitle());
        movie.setGenre(genre);
        movie.setStudio(studio);
        movie.setFranchise(franchise);
        movie.setStreaming(streaming);

        return movieRepository.save(movie);
    }

    @Override
    public List<MovieModel> getAll() {
        return movieRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<MovieModel> getById(Long id) {
        return Optional.ofNullable(movieRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Movie not found with id: " + id)));
    }

    @SuppressWarnings("null")
    @Override
    public MovieModel updateById(Long id, MovieModel movie) {
        MovieModel movieToUpdate = movieRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Movie not found with id: " + id));

        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            movie.setTitle(movieToUpdate.getTitle());
        }

        if (movie.getGenre() == null) {
            movie.setGenre(movieToUpdate.getGenre());
        }

        if (movie.getStudio() == null) {
            movie.setStudio(movieToUpdate.getStudio());
        }

        if (movie.getFranchise() == null) {
            movie.setFranchise(movieToUpdate.getFranchise());
        }

        if (movie.getStreaming() == null) {
            movie.setStreaming(movieToUpdate.getStreaming());
        }

        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setStudio(movie.getStudio());
        movieToUpdate.setFranchise(movie.getFranchise());
        movieToUpdate.setStreaming(movie.getStreaming());
                
        return movieRepository.save(movieToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(@Valid @NotNull Long id) {
        MovieModel movie = movieRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Movie not found with id: " + id));
        movieRepository.deleteById(movie.getId());
    }
}
