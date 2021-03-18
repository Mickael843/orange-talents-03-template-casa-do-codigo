package com.mikkaeru.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private @NotBlank String name;

    @OneToMany(mappedBy = "country")
    private List<State> states = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Customer> customers = new ArrayList<>();

    @Deprecated
    public Country() { }

    public Country(@NotBlank String name) {
        this.name = name;
    }
}
