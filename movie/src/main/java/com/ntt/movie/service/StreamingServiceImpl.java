package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.StreamingModel;
import com.ntt.movie.repository.StreamingRepository;
import com.ntt.movie.service.Inter.StreamingService;

@Service
public class StreamingServiceImpl implements StreamingService {
    @Autowired
    private StreamingRepository streamingRepository;

    @SuppressWarnings("null")
    @Override
    public StreamingModel create(StreamingModel streaming) {
        return streamingRepository.save(streaming);
    }

    @Override
    public List<StreamingModel> getAll() {
        return streamingRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<StreamingModel> getById(Long id) {
        return streamingRepository.findById(id);
    }

    @SuppressWarnings("null")
    @Override
    public StreamingModel updateById(Long id, StreamingModel streaming) {
        StreamingModel streamingToUpdate = streamingRepository.findById(id).orElse(null);

        streamingToUpdate.setName(streaming.getName());
        streamingToUpdate.setUrl(streaming.getUrl());
        
        return streamingRepository.save(streamingToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        streamingRepository.deleteById(id);
    }
}
