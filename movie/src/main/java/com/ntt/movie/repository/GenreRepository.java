package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.GenreModel;

public interface GenreRepository extends JpaRepository<GenreModel, Long>{}
