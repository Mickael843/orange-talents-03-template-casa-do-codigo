package com.mikkaeru.casadocodigo.model;

import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private @ISBN @NotBlank String isbn;

    @Column(nullable = false, unique = true)
    private @NotBlank String title;

    @Column(nullable = false, length = 500)
    private @NotBlank @Size(max = 500) String synopsis;

    @Lob
    private String summary;

    @Column(nullable = false)
    private @NotNull @Min(20) BigDecimal price;

    @Column(nullable = false)
    private @NotNull @Min(100) int pageNumber;

    private @Future LocalDate publicationDate;

    @ManyToOne(optional = false)
    private @NotNull Author author;

    @ManyToOne(optional = false)
    private @NotNull Category category;

    @Deprecated
    public Book() {
    }

    public Book(@ISBN @NotBlank String isbn, @NotBlank String title, @NotBlank @Size(max = 500) String synopsis,
                String summary, @Min(20) @NotNull BigDecimal price, @Min(100) @NotNull int pageNumber,
                @Future LocalDate publicationDate, @NotNull @Valid Author author, @NotNull @Valid Category category) {
        this.isbn = isbn;
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.pageNumber = pageNumber;
        this.publicationDate = publicationDate;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Author getAuthor() {
        return author;
    }
}
