package com.mikkaeru.casadocodigo.controller;

import com.mikkaeru.casadocodigo.dto.in.CustomerRequest;
import com.mikkaeru.casadocodigo.dto.out.customerSavedResponse;
import com.mikkaeru.casadocodigo.model.Customer;
import com.mikkaeru.casadocodigo.repository.CountryRepository;
import com.mikkaeru.casadocodigo.repository.CustomerRepository;
import com.mikkaeru.casadocodigo.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;
    private CountryRepository countryRepository;
    private StateRepository stateRepository;

    public CustomerController(CustomerRepository customerRepository, CountryRepository countryRepository, StateRepository stateRepository) {
        this.customerRepository = customerRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveCustomer(@RequestBody @Valid CustomerRequest request) {
        Customer customer = customerRepository.save(request.toModel(countryRepository, stateRepository));
        return ResponseEntity.ok(new customerSavedResponse(customer));
    }
}
