package com.mikkaeru.casadocodigo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mikkaeru.casadocodigo.model.Category;
import com.mikkaeru.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = Category.class)
    private final String name;

    @JsonCreator
    public CategoryRequest(@NotBlank @JsonProperty("name") String name) {
        this.name = name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
