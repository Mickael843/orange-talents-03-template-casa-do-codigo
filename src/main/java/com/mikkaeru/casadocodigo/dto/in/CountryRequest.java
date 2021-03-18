package com.mikkaeru.casadocodigo.dto.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mikkaeru.casadocodigo.model.Country;
import com.mikkaeru.casadocodigo.validator.duplicateValue.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CountryRequest {

    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = Country.class)
    private String name;

    @JsonCreator
    public CountryRequest(@NotBlank @JsonProperty("name") String name) {
        this.name = name;
    }

    public Country toModel() {
        return new Country(name);
    }
}
