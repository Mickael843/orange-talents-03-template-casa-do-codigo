package com.mikkaeru.casadocodigo.dto.out;

import com.mikkaeru.casadocodigo.model.Customer;

public class customerSavedResponse {

    private final Long id;

    public customerSavedResponse(Customer customer) {
        this.id = customer.getId();
    }

    public Long getId() {
        return id;
    }
}
