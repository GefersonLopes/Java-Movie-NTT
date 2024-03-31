package com.ntt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.movie.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
  boolean existsByEmail(String email);

  boolean existsByUsername(String username);
}
