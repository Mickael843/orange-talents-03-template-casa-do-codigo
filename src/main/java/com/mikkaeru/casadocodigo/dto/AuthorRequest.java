package com.mikkaeru.casadocodigo.dto;

import com.mikkaeru.casadocodigo.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {

    @NotBlank
    private final String name;

    @Email
    @NotBlank
    private final String email;

    @NotBlank
    @Size(max = 400)
    private final String description;

    public AuthorRequest(@NotBlank String name, @Email @NotBlank String email, @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }
}
