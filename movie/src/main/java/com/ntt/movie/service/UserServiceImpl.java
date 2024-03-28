package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.model.UserModel;
import com.ntt.movie.repository.UserRepository;
import com.ntt.movie.service.Inter.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    public UserModel create(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<UserModel> getById(Long id) {
        return Optional.ofNullable(userRepository.findById(id).orElse(null));
    }

    @SuppressWarnings("null")
    @Override
    public UserModel updateById(Long id, UserModel user) {
        UserModel userToUpdate = userRepository.findById(id).orElse(null);

        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        
        return userRepository.save(userToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
