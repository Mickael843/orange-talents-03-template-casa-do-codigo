package com.mikkaeru.casadocodigo.controller;

import com.mikkaeru.casadocodigo.dto.in.BookRequest;
import com.mikkaeru.casadocodigo.dto.out.BookDetailResponse;
import com.mikkaeru.casadocodigo.dto.out.BookResponse;
import com.mikkaeru.casadocodigo.model.Book;
import com.mikkaeru.casadocodigo.repository.AuthorRepository;
import com.mikkaeru.casadocodigo.repository.BookRepository;
import com.mikkaeru.casadocodigo.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<BookResponse> response = new ArrayList<>();
        bookRepository.findAll().forEach(book -> response.add(new BookResponse(book)));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneBook(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new BookDetailResponse(book.get()));
    }
}
