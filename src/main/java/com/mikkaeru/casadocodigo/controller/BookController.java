package com.mikkaeru.casadocodigo.controller;

import com.mikkaeru.casadocodigo.dto.BookRequest;
import com.mikkaeru.casadocodigo.repository.AuthorRepository;
import com.mikkaeru.casadocodigo.repository.BookRepository;
import com.mikkaeru.casadocodigo.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveBook(@RequestBody @Valid BookRequest request) {
        bookRepository.save(request.toModel(authorRepository, categoryRepository));
        return ResponseEntity.ok().build();
    }
}
