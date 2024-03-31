package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.GenreModel;
import com.ntt.movie.repository.GenreRepository;
import com.ntt.movie.service.Inter.GenreService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    @Transactional
    public GenreModel create(GenreModel genre) {
        if(genre.getId() != null) {
            throw new ExceptionNotFound("id not allowed.");
        }

        if (genre.getName() == null || genre.getName().isEmpty()) {
            throw new ExceptionNotFound("name is required.");
        }

        return genreRepository.save(genre);
    }

    @Override
    public List<GenreModel> getAll() {
        return genreRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<GenreModel> getById(@Valid @NotNull Long id) {
        return Optional.ofNullable(genreRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Genre not found with id: " + id)));
    }

    @SuppressWarnings("null")
    @Override
    public GenreModel updateById(Long id, GenreModel genre) {
        if (genre.getName() == null || genre.getName().isEmpty()) {
            throw new ExceptionNotFound("name is required.");
        }

        GenreModel genreToUpdate = genreRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Genre not found with id: " + id));

        genreToUpdate.setName(genre.getName());
        
        return genreRepository.save(genreToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(@Valid @NotNull Long id) {
        GenreModel genre = genreRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Genre not found with id: " + id));
        genreRepository.deleteById(genre.getId());
    }
}
