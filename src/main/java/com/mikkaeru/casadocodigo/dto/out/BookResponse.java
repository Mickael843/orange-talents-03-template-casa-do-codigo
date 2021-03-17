package com.mikkaeru.casadocodigo.dto.out;

import com.mikkaeru.casadocodigo.model.Book;

public class BookResponse {

    private final long id;
    private final String title;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
