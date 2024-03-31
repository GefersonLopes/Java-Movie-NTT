package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.MovieModel;
import com.ntt.movie.model.dto.MovieCreateRequestDTO;
import com.ntt.movie.service.Inter.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieModel>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovieModel>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MovieModel> create(@RequestBody MovieCreateRequestDTO movie) {
        return ResponseEntity.ok(movieService.create(movie));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieModel> updateById(@PathVariable Long id, @RequestBody MovieModel movie) {
        return ResponseEntity.ok(movieService.updateById(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
