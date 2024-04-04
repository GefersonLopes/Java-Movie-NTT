package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.UserModel;
import com.ntt.movie.repository.UserRepository;
import com.ntt.movie.service.Inter.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserModel create(@Valid @NotNull UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getById(@Valid @NotNull Long id) {
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("User not found with id: " + id)));
    }

    @Override
    public UserModel updateById(Long id, UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(@Valid @NotNull Long id) {
        userRepository.deleteById(id);
    }
}
