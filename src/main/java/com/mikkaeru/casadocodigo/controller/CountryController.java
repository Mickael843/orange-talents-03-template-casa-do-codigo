package com.mikkaeru.casadocodigo.controller;

import com.mikkaeru.casadocodigo.dto.in.CountryRequest;
import com.mikkaeru.casadocodigo.repository.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<?> saveCountry(@RequestBody @Valid CountryRequest request) {
        countryRepository.save(request.toModel());
        return ResponseEntity.ok().build();
    }
}
