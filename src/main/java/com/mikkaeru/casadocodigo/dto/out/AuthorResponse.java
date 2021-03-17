package com.mikkaeru.casadocodigo.dto.out;

import com.mikkaeru.casadocodigo.model.Author;

public class AuthorResponse {

    private final String name;
    private final String description;

    public AuthorResponse(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
