package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.RoleModel;
import com.ntt.movie.repository.RoleRepository;
import com.ntt.movie.service.Inter.RoleService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public RoleModel create(@Valid @NotNull RoleModel role) {
        if(role.getId() != null) {
            throw new ExceptionBadRequest("id not allowed.");
        }

        if (role.getName() == null || role.getName().isEmpty()) {
            throw new ExceptionBadRequest("name is required.");
        }

        return roleRepository.save(role);
    }

    @Override
    public List<RoleModel> getAll() {
        return roleRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<RoleModel> getById(@Valid @NotNull Long id) {
        return Optional.ofNullable(roleRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Role not found with id: " + id)));
    }

    @SuppressWarnings("null")
    @Override
    public RoleModel updateById(Long id, RoleModel role) {
        if (role.getName() == null || role.getName().isEmpty()) {
            throw new ExceptionBadRequest("name is required.");
        }

        RoleModel roleToUpdate = roleRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Role not found with id: " + id));

        roleToUpdate.setName(role.getName());
        
        return roleRepository.save(roleToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(@Valid @NotNull Long id) {
        RoleModel role = roleRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Role not found with id: " + id));
        roleRepository.deleteById(role.getId());
    }
}