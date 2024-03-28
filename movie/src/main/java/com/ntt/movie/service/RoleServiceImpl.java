package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.RoleModel;
import com.ntt.movie.repository.RoleRepository;
import com.ntt.movie.service.Inter.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @SuppressWarnings("null")
    @Override
    public RoleModel create(RoleModel role) {
        return roleRepository.save(role);
    }

    @Override
    public List<RoleModel> getAll() {
        return roleRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<RoleModel> getById(Long id) {
        return Optional.ofNullable(roleRepository.findById(id).orElse(null));
    }

    @SuppressWarnings("null")
    @Override
    public RoleModel updateById(Long id, RoleModel role) {
        RoleModel roleToUpdate = roleRepository.findById(id).orElse(null);

        roleToUpdate.setName(role.getName());
        
        return roleRepository.save(roleToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}