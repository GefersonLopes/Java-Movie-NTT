package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.StreamingModel;
import com.ntt.movie.service.Inter.StreamingService;

@RestController
@RequestMapping("/streaming")
public class StreamingController {
    @Autowired
    private StreamingService streamingService;

    @PostMapping
    public ResponseEntity<StreamingModel> create(@RequestBody StreamingModel streaming) {
        return ResponseEntity.ok(streamingService.create(streaming));
    }

    @GetMapping
    public ResponseEntity<List<StreamingModel>> getAll() {
        return ResponseEntity.ok(streamingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StreamingModel>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(streamingService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StreamingModel> updateById(@PathVariable Long id, @RequestBody StreamingModel streaming) {
        return ResponseEntity.ok(streamingService.updateById(id, streaming));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-movie")
    public ResponseEntity<StreamingModel> setMovies(@RequestBody Map<String, Long> request) {
        return ResponseEntity.ok(streamingService.setMovies(request.get("streaming_id"), request.get("movie_id")));
    }

    @DeleteMapping("/remove-movie")
    public ResponseEntity<?> deleteMovies(@RequestBody Map<String, Long> request) {
        streamingService.deleteMovies(request.get("streaming_id"), request.get("movie_id"));
        return ResponseEntity.ok().build();
    }
}
