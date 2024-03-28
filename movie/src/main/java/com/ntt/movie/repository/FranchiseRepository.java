package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.FranchiseModel;

public interface FranchiseRepository extends JpaRepository<FranchiseModel, Long>{}
