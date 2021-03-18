package com.mikkaeru.casadocodigo.dto.in;

import com.mikkaeru.casadocodigo.model.Country;
import com.mikkaeru.casadocodigo.model.State;
import com.mikkaeru.casadocodigo.repository.CountryRepository;
import com.mikkaeru.casadocodigo.validator.existsId.ExistsId;
import com.mikkaeru.casadocodigo.validator.duplicateValue.UniqueValue;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class StateRequest {

    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = State.class)
    private final String name;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Country.class)
    private final long countryId;

    public StateRequest(@NotBlank String name, @NotNull long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public State toModel(CountryRepository countryRepository) {
        Optional<Country> country = countryRepository.findById(countryId);

        if (country.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return new State(name, country.get());
    }
}
