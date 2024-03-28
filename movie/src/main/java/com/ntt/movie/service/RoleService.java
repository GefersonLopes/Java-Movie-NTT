package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.RoleModel;

public interface RoleService {
    RoleModel create(RoleModel role);

    List<RoleModel> getAll();

    Optional<RoleModel> getById(Long id);

    RoleModel updateById(Long id, RoleModel role);
    
    void delete(Long id);
}