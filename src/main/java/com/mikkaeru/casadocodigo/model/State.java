package com.mikkaeru.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private @NotBlank String name;

    @ManyToOne
    private Country country;

    @Deprecated
    public State() { }

    public State(@NotBlank String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
