package com.ntt.movie.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.FranchiseModel;
import com.ntt.movie.repository.FranchiseRepository;
import com.ntt.movie.service.Inter.FranchiseService;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;

    @SuppressWarnings("null")
    @Override
    public FranchiseModel create(FranchiseModel franchise) {
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
