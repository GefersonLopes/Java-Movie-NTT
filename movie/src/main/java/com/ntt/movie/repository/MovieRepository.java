package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.MovieModel;

public interface MovieRepository extends JpaRepository<MovieModel, Long>{}
