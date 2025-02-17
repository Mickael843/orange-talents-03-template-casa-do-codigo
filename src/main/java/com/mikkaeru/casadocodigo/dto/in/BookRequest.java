package com.mikkaeru.casadocodigo.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mikkaeru.casadocodigo.model.Author;
import com.mikkaeru.casadocodigo.model.Book;
import com.mikkaeru.casadocodigo.model.Category;
import com.mikkaeru.casadocodigo.repository.AuthorRepository;
import com.mikkaeru.casadocodigo.repository.CategoryRepository;
import com.mikkaeru.casadocodigo.validator.existsId.ExistsId;
import com.mikkaeru.casadocodigo.validator.duplicateValue.UniqueValue;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

public class BookRequest {

    @ISBN
    @NotBlank
    @UniqueValue(fieldName = "isbn", domainClass = Book.class)
    private String isbn;

    @NotBlank
    @UniqueValue(fieldName = "title", domainClass = Book.class)
    private String title;

    @NotBlank
    @Size(max = 500)
    private String synopsis;

    private String summary;

    @Min(20)
    @NotNull
    private BigDecimal price;

    @Min(100)
    @NotNull
    private int pageNumber;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd", shape = STRING)
    private LocalDate publicationDate;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Author.class)
    private long authorId;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Category.class)
    private long categoryId;

    public BookRequest(@ISBN @NotBlank String isbn, @NotBlank String title,
                       @NotBlank @Size(max = 500) String synopsis, String summary,
                       @Min(20) @NotNull BigDecimal price, @Min(100) @NotNull int pageNumber,
                       @Future LocalDate publicationDate, @NotNull long authorId, @NotNull long categoryId) {
        this.isbn = isbn;
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.pageNumber = pageNumber;
        this.publicationDate = publicationDate;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    public Book toModel(AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        Optional<Author> author = authorRepository.findById(authorId);
        Optional<Category> category = categoryRepository.findById(categoryId);

        if (author.isEmpty() || category.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return new Book(isbn, title, synopsis, summary, price, pageNumber, publicationDate, author.get(), category.get());
    }
}
