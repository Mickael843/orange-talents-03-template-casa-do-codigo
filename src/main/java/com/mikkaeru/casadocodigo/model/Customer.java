package com.mikkaeru.casadocodigo.model;

import com.mikkaeru.casadocodigo.validator.enumeration.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private @NotBlank @Email String email;

    private @NotBlank String name;

    private @NotBlank String lastname;

    private @NotBlank String document;

    private @NotBlank String address;

    private @NotBlank String complement;

    private @NotBlank String city;

    private @NotBlank String phone;

    private @NotBlank String cep;

    @ManyToOne(optional = false)
    private @NotNull Country country;

    @ManyToOne(optional = false)
    private @NotNull State state;

    private @NotNull CustomerType type;

    public Customer(@NotBlank @Email String email, @NotBlank String name, @NotBlank String lastname,
                    @NotBlank String document, @NotBlank String address, @NotBlank String complement,
                    @NotBlank String city, @NotBlank String phone, @NotBlank String cep,
                    @NotNull Country country, @NotNull State state, @NotNull CustomerType type) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.phone = phone;
        this.cep = cep;
        this.country = country;
        this.state = state;
        this.type = type;
    }

    public Long getId() {
        return id;
    }
}
