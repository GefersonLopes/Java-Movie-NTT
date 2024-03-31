package com.ntt.movie.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.FranchiseModel;
import com.ntt.movie.model.GenreModel;
import com.ntt.movie.model.StudioModel;
import com.ntt.movie.model.dto.FranchiseCreateRequestDTO;
import com.ntt.movie.repository.FranchiseRepository;
import com.ntt.movie.repository.GenreRepository;
import com.ntt.movie.repository.StudioRepository;
import com.ntt.movie.service.Inter.FranchiseService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private GenreRepository genreRepository;
    
    @Autowired
    private StudioRepository studioRepository;

    @SuppressWarnings("null")
    @Transactional
    public FranchiseModel create(@Valid @NotNull FranchiseCreateRequestDTO request) {
        if(request.getId() != null) {
            throw new ExceptionBadRequest("id not allowed.");
        }

        if (request.getName() == null || request.getName().isEmpty()) {
            throw new ExceptionBadRequest("name is required.");
        }

        GenreModel genre = genreRepository.findById(request.getGenre_id()).orElseThrow(() -> new ExceptionNotFound("Genre not found with id: " + request.getGenre_id()));
        StudioModel studio = studioRepository.findById(request.getStudio_id()).orElseThrow(() -> new ExceptionNotFound("Studio not found with id: " + request.getStudio_id()));

        FranchiseModel franchise = new FranchiseModel();
        franchise.setName(request.getName());
        franchise.setGenre(genre);
        franchise.setStudio(studio);

        return franchiseRepository.save(franchise);
    }

    @Override
    public List<FranchiseModel> getAll() {
        return franchiseRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<FranchiseModel> getById(@Valid @NotNull Long id) {
        return Optional.ofNullable(franchiseRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Franchise not found with id: " + id)));
    }

    @SuppressWarnings("null")
    @Override
    public FranchiseModel updateById(Long id, FranchiseCreateRequestDTO request) {
        FranchiseModel franchiseToUpdate = franchiseRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Franchise not found with id: " + id));

        GenreModel genre;
        StudioModel studio;

        if(request.getGenre_id() == null) {
            genre = genreRepository.findById(franchiseToUpdate.getGenre().getId())
                .orElseThrow(() -> new ExceptionNotFound("Genre not found with id: " + request.getGenre_id()));
        } else {
            genre = genreRepository.findById(request.getGenre_id())
                .orElseThrow(() -> new ExceptionNotFound("Genre not found with id: " + request.getGenre_id()));
        }

        if(request.getStudio_id() == null) {
            studio = studioRepository.findById(franchiseToUpdate.getStudio().getId())
                .orElseThrow(() -> new ExceptionNotFound("Studio not found with id: " + request.getStudio_id()));
        } else {
            studio = studioRepository.findById(request.getStudio_id())
                .orElseThrow(() -> new ExceptionNotFound("Studio not found with id: " + request.getStudio_id()));
        }

        if (request.getName() == null || request.getName().isEmpty()) {
            request.setName(franchiseToUpdate.getName());
        }
        
        franchiseToUpdate.setName(request.getName());
        franchiseToUpdate.setGenre(genre);
        franchiseToUpdate.setStudio(studio);

        return franchiseRepository.save(franchiseToUpdate);
    }
    
    @SuppressWarnings("null")
    @Override
    public void delete(@Valid @NotNull Long id) {
        FranchiseModel franchise = franchiseRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Franchise not found with id: " + id));
        franchiseRepository.deleteById(franchise.getId());
    }
}
