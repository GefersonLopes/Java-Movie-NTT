package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.DirectorModel;
import com.ntt.movie.service.Inter.DirectorService;

@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @PostMapping
    public ResponseEntity<DirectorModel> create(@RequestBody DirectorModel director) {
        return ResponseEntity.ok(directorService.create(director));
    }

    @GetMapping
    public ResponseEntity<List<DirectorModel>> getAll() {
        return ResponseEntity.ok(directorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(directorService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DirectorModel> updateById(@PathVariable Long id, @RequestBody DirectorModel director) {
        return ResponseEntity.ok(directorService.updateById(id, director));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        directorService.delete(id);
        return ResponseEntity.ok().build();
    }    
}