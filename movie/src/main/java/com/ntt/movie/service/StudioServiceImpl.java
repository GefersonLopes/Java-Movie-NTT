package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.StudioModel;
import com.ntt.movie.repository.StudioRepository;
import com.ntt.movie.service.Inter.StudioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    private StudioRepository studioRepository;

    @Override
    @Transactional
    public StudioModel create(@Valid @NotNull StudioModel studio) {
        if(studio.getId() != null) {
            throw new ExceptionBadRequest("id not allowed.");
        }

        if (studio.getName() == null || studio.getName().isEmpty()) {
            throw new ExceptionBadRequest("name is required.");
        }

        if (studio.getCountry() == null || studio.getCountry().isEmpty()) {
            throw new ExceptionBadRequest("country is required.");
        }

        return studioRepository.save(studio);
    }

    @Override
    public List<StudioModel> getAll() {
        return studioRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<StudioModel> getById(@Valid @NotNull Long id) {
        return Optional.ofNullable(studioRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Studio not found with id: " + id)));
    }

    @SuppressWarnings("null")
    @Override
    public StudioModel updateById(Long id, StudioModel actor) {
        StudioModel actorToUpdate = studioRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Studio not found with id: " + id));

        if (actor.getName() == null || actor.getName().isEmpty()) {
            actor.setName(actorToUpdate.getName());    
        }

        if (actor.getCountry() == null || actor.getCountry().isEmpty()) {
            actor.setCountry(actorToUpdate.getCountry());
        }

        actorToUpdate.setName(actor.getName());
        actorToUpdate.setCountry(actor.getCountry());
        
        return studioRepository.save(actorToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(@Valid @NotNull Long id) {
        StudioModel actor = studioRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Studio not found with id: " + id));
        studioRepository.deleteById(actor.getId());
    }
}
