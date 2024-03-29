package com.ntt.movie.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.FranchiseModel;
import com.ntt.movie.model.GenreModel;
import com.ntt.movie.model.StudioModel;
import com.ntt.movie.model.dto.FranchiseCreateRequestDTO;
import com.ntt.movie.repository.FranchiseRepository;
import com.ntt.movie.repository.GenreRepository;
import com.ntt.movie.repository.StudioRepository;
import com.ntt.movie.service.Inter.FranchiseService;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private GenreRepository genreRepository;
    
    @Autowired
    private StudioRepository studioRepository;

    @SuppressWarnings("null")
    @Override
    public FranchiseModel create(FranchiseCreateRequestDTO request) {

        Optional<GenreModel> optionalGenre = genreRepository.findById(request.getGenre_id());
        Optional<StudioModel> optionalStudio = studioRepository.findById(request.getStudio_id());

        GenreModel genre = optionalGenre.get();
        StudioModel studio = optionalStudio.get();

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
    public Optional<FranchiseModel> getById(Long id) {
        return Optional.ofNullable(franchiseRepository.findById(id).orElse(null));
    }

    @SuppressWarnings("null")
    @Override
    public FranchiseModel updateById(Long id, FranchiseModel franchise) {
        FranchiseModel franchiseToUpdate = franchiseRepository.findById(id).orElse(null);

        franchiseToUpdate.setName(franchise.getName());
        
        return franchiseRepository.save(franchiseToUpdate);
    }
    
    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        franchiseRepository.deleteById(id);
    }
}
