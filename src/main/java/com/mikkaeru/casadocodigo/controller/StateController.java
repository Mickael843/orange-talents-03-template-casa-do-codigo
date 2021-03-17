package com.mikkaeru.casadocodigo.controller;

import com.mikkaeru.casadocodigo.dto.in.StateRequest;
import com.mikkaeru.casadocodigo.repository.CountryRepository;
import com.mikkaeru.casadocodigo.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/states")
public class StateController {

    private StateRepository stateRepository;
    private CountryRepository countryRepository;

    public StateController(StateRepository stateRepository, CountryRepository countryRepository) {
        this.stateRepository = stateRepository;
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<?> saveState(@RequestBody @Valid StateRequest request) {
        stateRepository.save(request.toModel(countryRepository));
        return ResponseEntity.ok().build();
    }
}
