package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.GenreModel;
import com.ntt.movie.repository.GenreRepository;
import com.ntt.movie.service.Inter.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @SuppressWarnings("null")
    @Override
    public GenreModel create(GenreModel genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<GenreModel> getAll() {
        return genreRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<GenreModel> getById(Long id) {
        return genreRepository.findById(id);
    }

    @SuppressWarnings("null")
    @Override
    public GenreModel updateById(Long id, GenreModel genre) {
        GenreModel genreToUpdate = genreRepository.findById(id).orElse(null);

        genreToUpdate.setName(genre.getName());
        
        return genreRepository.save(genreToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
