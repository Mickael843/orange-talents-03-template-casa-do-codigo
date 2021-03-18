package com.mikkaeru.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private @NotBlank String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    @Deprecated
    public Category() { }

    public Category(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
