package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.DirectorModel;

public interface DirectorRepository extends JpaRepository<DirectorModel, Long>{}
