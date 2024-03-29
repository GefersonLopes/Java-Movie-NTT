package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.*;
import com.ntt.movie.model.dto.MovieCreateRequestDTO;
import com.ntt.movie.repository.*;
import com.ntt.movie.service.Inter.MovieService;

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
    public MovieModel create(MovieCreateRequestDTO request) {

        Optional<GenreModel> optionalGenre = genreRepository.findById(request.getGenre_id());
        Optional<StudioModel> optionalStudio = studioRepository.findById(request.getStudio_id());
        Optional<FranchiseModel> optionalFranchise = franchiseRepository.findById(request.getFranchise_id());
        Optional<StreamingModel> optionalStreaming = streamingRepository.findById(request.getStreaming_id());

        GenreModel genre = optionalGenre.get();
        StudioModel studio = optionalStudio.get();
        FranchiseModel franchise = optionalFranchise.get();
        StreamingModel streaming = optionalStreaming.get();

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
