package com.ntt.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.DirectorModel;
import com.ntt.movie.repository.DirectorRepository;
import com.ntt.movie.service.Inter.DirectorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class DirectorServiceImpl implements DirectorService {
  @Autowired
  private DirectorRepository directorRepository;

  @Override
  @Transactional
  public DirectorModel create(@Valid @NotNull DirectorModel director) {
    if(director.getId() != null) {
      throw new ExceptionBadRequest("id not allowed.");
    }

    if (director.getName() == null || director.getName().isEmpty()) {
      throw new ExceptionBadRequest("name is required.");
    }

    return directorRepository.save(director);
  }

  @Override
  public List<DirectorModel> getAll() {
    return directorRepository.findAll();
  }
  
  @SuppressWarnings("null")
  @Override
  public DirectorModel getById(@Valid @NotNull Long id) {
    return directorRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Director not found with id: " + id));
  }
  
  @SuppressWarnings("null")
  @Override
  public DirectorModel updateById(Long id, DirectorModel director) {
    if (director.getName() == null || director.getName().isEmpty()) {
      throw new ExceptionBadRequest("name is required.");
    }

    DirectorModel directorToUpdate = directorRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Director not found with id: " + id));

    directorToUpdate.setName(director.getName());
    
    return directorRepository.save(directorToUpdate);
  }

  @SuppressWarnings("null")
  @Override
  public void delete(@Valid @NotNull Long id) {
    DirectorModel director = directorRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Director not found with id: " + id));
    directorRepository.deleteById(director.getId());
  }
  
}
