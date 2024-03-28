package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long>{}