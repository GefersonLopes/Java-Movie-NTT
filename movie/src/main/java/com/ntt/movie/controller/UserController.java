package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.dto.FavoritesMovieDirectorToUserDTO;
import com.ntt.movie.model.dto.UserDTO;
import com.ntt.movie.service.facades.UserFacade;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserFacade userFacade;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userFacade.create(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userFacade.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> updateById(@PathVariable Long id, @RequestBody UserDTO user) {
        return ResponseEntity.ok(userFacade.updateById(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userFacade.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/favorites-movie/{id}")
    public UserDTO setFavoritesMovies(@PathVariable Long id, @RequestBody FavoritesMovieDirectorToUserDTO itemsFavorite) {        
        return userFacade.setFavoritesMovies(id, itemsFavorite);
    }
}
