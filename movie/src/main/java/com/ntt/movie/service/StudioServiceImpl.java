package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.StudioModel;
import com.ntt.movie.repository.StudioRepository;
import com.ntt.movie.service.Inter.StudioService;

@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    private StudioRepository studioRepository;

    @SuppressWarnings("null")
    @Override
    public StudioModel create(StudioModel studio) {
        return studioRepository.save(studio);
    }

    @Override
    public List<StudioModel> getAll() {
        return studioRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<StudioModel> getById(Long id) {
        return Optional.ofNullable(studioRepository.findById(id).orElse(null));
    }

    @SuppressWarnings("null")
    @Override
    public StudioModel updateById(Long id, StudioModel actor) {
        StudioModel actorToUpdate = studioRepository.findById(id).orElse(null);

        actorToUpdate.setName(actor.getName());
        actorToUpdate.setCountry(actor.getCountry());
        
        return studioRepository.save(actorToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        studioRepository.deleteById(id);
    }
}
