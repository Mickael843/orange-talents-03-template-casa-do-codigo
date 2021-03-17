package com.mikkaeru.casadocodigo.controller;

import com.mikkaeru.casadocodigo.dto.BookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveBook(@RequestBody @Valid BookRequest request) {
        entityManager.persist(request.toModel(entityManager));
        return ResponseEntity.ok().build();
    }
}
