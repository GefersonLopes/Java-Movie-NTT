package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.UserModel;
import com.ntt.movie.model.dto.FavoritesMovieDirectorToUserDTO;
import com.ntt.movie.service.Inter.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserModel> updateById(@PathVariable Long id, @RequestBody UserModel user) {
        return ResponseEntity.ok(userService.updateById(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/favorites-movie/{id}")
    public UserModel setFavoritesMovies(@PathVariable Long id, @RequestBody FavoritesMovieDirectorToUserDTO itemsFavorite) {        
        return userService.setFavoritesMovies(id, itemsFavorite);
    }
}
