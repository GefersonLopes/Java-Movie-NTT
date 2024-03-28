package com.ntt.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.DirectorModel;
import com.ntt.movie.repository.DirectorRepository;
import com.ntt.movie.service.Inter.DirectorService;

@Service
public class DirectorServiceImpl implements DirectorService {
  @Autowired
  private DirectorRepository directorRepository;

  @SuppressWarnings("null")
  @Override
  public DirectorModel create(DirectorModel director) {
    return directorRepository.save(director);
  }

  @Override
  public List<DirectorModel> getAll() {
    return directorRepository.findAll();
  }
  
  @SuppressWarnings("null")
  @Override
  public DirectorModel getById(Long id) {
    return directorRepository.findById(id).orElse(null);
  }
  
  @SuppressWarnings("null")
  @Override
  public DirectorModel updateById(Long id, DirectorModel director) {
    DirectorModel directorToUpdate = directorRepository.findById(id).orElse(null);

    directorToUpdate.setName(director.getName());
    
    return directorRepository.save(directorToUpdate);
  }

  @SuppressWarnings("null")
  @Override
  public void delete(Long id) {
    directorRepository.deleteById(id);
  }
  
}
