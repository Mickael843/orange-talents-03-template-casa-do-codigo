package com.mikkaeru.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private @NotBlank String name;

    @Column(nullable = false, unique = true)
    private @NotBlank @Email String email;

    @Column(nullable = false, length = 400)
    private @NotBlank @Size(max = 400) String description;

    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    @Deprecated
    public Author() { }

    public Author(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public List<Book> getBooks() {
        return books;
    }
}
