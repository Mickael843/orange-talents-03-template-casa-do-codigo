package com.mikkaeru.casadocodigo.controller;

import com.mikkaeru.casadocodigo.dto.in.AuthorRequest;
import com.mikkaeru.casadocodigo.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveAuthor(@RequestBody @Valid AuthorRequest request) {
        authorRepository.save(request.toModel());
        return ResponseEntity.ok().build();
    }
}
