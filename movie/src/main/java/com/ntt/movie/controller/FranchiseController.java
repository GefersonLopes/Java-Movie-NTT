package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.FranchiseModel;
import com.ntt.movie.model.dto.FranchiseCreateRequestDTO;
import com.ntt.movie.service.Inter.FranchiseService;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping("")
    public ResponseEntity<List<FranchiseModel>> getAll() {
        return ResponseEntity.ok(franchiseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FranchiseModel>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(franchiseService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<FranchiseModel> create(@RequestBody FranchiseCreateRequestDTO franchise) {
        return ResponseEntity.ok(franchiseService.create(franchise));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FranchiseModel> updateById(@PathVariable Long id, @RequestBody FranchiseCreateRequestDTO franchise) {
        return ResponseEntity.ok(franchiseService.updateById(id, franchise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        franchiseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
