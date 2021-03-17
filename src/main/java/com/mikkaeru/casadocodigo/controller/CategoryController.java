package com.mikkaeru.casadocodigo.controller;

import com.mikkaeru.casadocodigo.dto.in.CategoryRequest;
import com.mikkaeru.casadocodigo.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveCategory(@RequestBody @Valid CategoryRequest request) {
        repository.save(request.toModel());
        return ResponseEntity.ok().build();
    }
}
