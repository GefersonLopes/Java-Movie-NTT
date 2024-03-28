package com.ntt.movie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntt.movie.model.RoleModel;
import com.ntt.movie.service.Inter.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleModel> create(@RequestBody RoleModel role) {
        return ResponseEntity.ok(roleService.create(role));
    }

    @GetMapping
    public ResponseEntity<List<RoleModel>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RoleModel>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoleModel> updateById(@PathVariable Long id, @RequestBody RoleModel role) {
        return ResponseEntity.ok(roleService.updateById(id, role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
}