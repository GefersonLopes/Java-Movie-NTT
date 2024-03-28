package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.StudioModel;
import com.ntt.movie.service.Inter.StudioService;

@RestController
@RequestMapping("/studio")
public class StudioController {
    @Autowired
    private StudioService studioService;

    @PostMapping
    public ResponseEntity<StudioModel> create(@RequestBody StudioModel studio) {
        return ResponseEntity.ok(studioService.create(studio));
    }

    @GetMapping
    public ResponseEntity<List<StudioModel>> getAll() {
        return ResponseEntity.ok(studioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StudioModel>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studioService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudioModel> updateById(@PathVariable Long id, @RequestBody StudioModel studio) {
        return ResponseEntity.ok(studioService.updateById(id, studio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
