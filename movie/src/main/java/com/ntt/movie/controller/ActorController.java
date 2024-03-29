package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.ActorModel;
import com.ntt.movie.service.Inter.ActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @PostMapping("")
    public ResponseEntity<ActorModel> create(@RequestBody ActorModel actor) {
        ActorModel createdActor = actorService.create(actor);
        return ResponseEntity.ok().body(createdActor);
    }

    @GetMapping("")
    public ResponseEntity<List<ActorModel>> getAll() {
        List<ActorModel> actors = actorService.getAll();
        return ResponseEntity.ok().body(actors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ActorModel>> getById(@PathVariable long id) {
        Optional<ActorModel> actor = actorService.getById(id);
        if (actor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(actor);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ActorModel> updateById(@PathVariable long id, @RequestBody ActorModel actor) {
        ActorModel updatedActor = actorService.updateById(id, actor);
        return ResponseEntity.ok().body(updatedActor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        actorService.delete(id);
        return ResponseEntity.ok().build();
    }
}