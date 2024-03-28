package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.ActorModel;

public interface ActorRepository extends JpaRepository<ActorModel, Long>{}