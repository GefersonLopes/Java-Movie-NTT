package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.StudioModel;

public interface StudioRepository extends JpaRepository<StudioModel, Long>{}
