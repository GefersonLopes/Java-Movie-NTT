package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.StreamingModel;

public interface StreamingRepository extends JpaRepository<StreamingModel, Long>{}
