package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.ActorModel;
import com.ntt.movie.repository.ActorRepository;
import com.ntt.movie.service.Inter.ActorService;

@Service
public class ActorSerciveImpl implements ActorService {
  @Autowired
  private ActorRepository actorRepository;

  @SuppressWarnings("null")
  @Override
  public ActorModel create(ActorModel actor) {
    return actorRepository.save(actor);
  }

  @Override
  public List<ActorModel> getAll() {
    return actorRepository.findAll();
  }

  @SuppressWarnings("null")
  @Override
  public Optional<ActorModel> getById(Long id) {
    return Optional.ofNullable(actorRepository.findById(id).orElse(null));
  }

  @SuppressWarnings("null")
  @Override
  public ActorModel updateById(Long id, ActorModel actor) {
    ActorModel actorToUpdate = actorRepository.findById(id).orElse(null);

    actorToUpdate.setName(actor.getName());
    
    return actorRepository.save(actorToUpdate);
  }

  @SuppressWarnings("null")
  @Override
  public void delete(Long id) {
    actorRepository.deleteById(id);
  }

}
