package com.mikkaeru.casadocodigo.dto.out;

import com.mikkaeru.casadocodigo.model.Book;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class BookDetailResponse {

    private final String isbn;
    private final String title;
    private final String synopsis;
    private final String summary;
    private final BigDecimal price;
    private final int pageNumber;
    private final String publicationDate;
    private final AuthorResponse author;

    public BookDetailResponse(Book book) {
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.synopsis = book.getSynopsis();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.pageNumber = book.getPageNumber();
        this.author = new AuthorResponse(book.getAuthor());
        this.publicationDate = book.getPublicationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public String getPublicationDate() {
        return publicationDate;
    }

    public AuthorResponse getAuthor() {
        return author;
    }
}
