package com.mikkaeru.casadocodigo.dto;

public class BookResponse {

    private long id;
    private String title;

    public BookResponse(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
