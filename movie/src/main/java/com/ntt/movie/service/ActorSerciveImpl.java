package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.model.ActorModel;
import com.ntt.movie.repository.ActorRepository;
import com.ntt.movie.service.Inter.ActorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class ActorSerciveImpl implements ActorService {
  @Autowired
  private ActorRepository actorRepository;

  @Override
  @Transactional
  public ActorModel create(@Valid @NotNull ActorModel actor) {
      if(actor.getId() != null) {
        throw new ExceptionBadRequest("id not allowed.");
      }

      if (actor.getName() == null || actor.getName().isEmpty()) {
          throw new ExceptionBadRequest("name is required.");
      }

      ActorModel savedActor = actorRepository.save(actor);
      return savedActor;
  }

  @Override
  public List<ActorModel> getAll() {
    return actorRepository.findAll();
  }

  @SuppressWarnings("null")
  @Override
  public Optional<ActorModel> getById(@Valid @NotNull Long id) {
    return Optional.ofNullable(actorRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Actor not found with id: " + id)));
  }

  @SuppressWarnings("null")
  @Override
  public ActorModel updateById(Long id, ActorModel actor) {
    if (actor.getName() == null || actor.getName().isEmpty()) {
      throw new ExceptionBadRequest("name is required.");
    }

    ActorModel actorToUpdate = actorRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Actor not found with id: " + id));

    actorToUpdate.setName(actor.getName());
    
    return actorRepository.save(actorToUpdate);
  }

  @SuppressWarnings("null")
  @Override
  public void delete(@Valid @NotNull Long id) {
    ActorModel actor = actorRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Actor not found with id: " + id));
    actorRepository.deleteById(actor.getId());
  }

}
