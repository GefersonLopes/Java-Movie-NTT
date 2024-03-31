package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.StreamingModel;
import com.ntt.movie.repository.StreamingRepository;
import com.ntt.movie.service.Inter.StreamingService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class StreamingServiceImpl implements StreamingService {
    @Autowired
    private StreamingRepository streamingRepository;

    @Override
    @Transactional
    public StreamingModel create(@Valid @NotNull StreamingModel streaming) {
        if(streaming.getId() != null) {
            throw new ExceptionBadRequest("id not allowed.");
        }

        if (streaming.getName() == null || streaming.getName().isEmpty()) {
            throw new ExceptionBadRequest("name is required.");
        }

        if (streaming.getUrl() == null || streaming.getUrl().isEmpty()) {
            throw new ExceptionBadRequest("url is required.");
        }

        return streamingRepository.save(streaming);
    }

    @Override
    public List<StreamingModel> getAll() {
        return streamingRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<StreamingModel> getById(@Valid @NotNull Long id) {
        return Optional.ofNullable(streamingRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Streaming not found with id: " + id)));
    }

    @SuppressWarnings("null")
    @Override
    public StreamingModel updateById(Long id, StreamingModel streaming) {
        StreamingModel streamingToUpdate = streamingRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Streaming not found with id: " + id));

        if (streaming.getName() == null || streaming.getName().isEmpty()) {
            streaming.setName(streamingToUpdate.getName());
        }

        if (streaming.getUrl() == null || streaming.getUrl().isEmpty()) {
            streaming.setUrl(streamingToUpdate.getUrl());
        }
        
        streamingToUpdate.setName(streaming.getName());
        streamingToUpdate.setUrl(streaming.getUrl());
        
        return streamingRepository.save(streamingToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(@Valid @NotNull Long id) {
        StreamingModel streaming = streamingRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Streaming not found with id: " + id));
        streamingRepository.deleteById(streaming.getId());
    }
}
