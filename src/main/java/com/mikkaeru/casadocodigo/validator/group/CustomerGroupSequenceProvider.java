package com.mikkaeru.casadocodigo.validator.group;

import com.mikkaeru.casadocodigo.dto.in.CustomerRequest;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class CustomerGroupSequenceProvider implements DefaultGroupSequenceProvider<CustomerRequest> {

    @Override
    public List<Class<?>> getValidationGroups(CustomerRequest customerRequest) {

        List<Class<?>> groups = new ArrayList<>();
        groups.add(CustomerRequest.class);

        if (isCustomerSelected(customerRequest)) {
            groups.add(customerRequest.getCustomerType().getGroup());
        }

        return groups;
    }

    private boolean isCustomerSelected(CustomerRequest customerRequest) {
        return customerRequest != null && customerRequest.getCustomerType() != null;
    }
}
