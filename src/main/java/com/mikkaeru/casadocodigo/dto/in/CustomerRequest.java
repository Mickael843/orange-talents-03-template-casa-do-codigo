package com.mikkaeru.casadocodigo.dto.in;

import com.mikkaeru.casadocodigo.model.Country;
import com.mikkaeru.casadocodigo.model.Customer;
import com.mikkaeru.casadocodigo.model.State;
import com.mikkaeru.casadocodigo.repository.CountryRepository;
import com.mikkaeru.casadocodigo.repository.StateRepository;
import com.mikkaeru.casadocodigo.validator.existsRelationship.ExistsRelationship;
import com.mikkaeru.casadocodigo.validator.duplicateValue.UniqueValue;
import com.mikkaeru.casadocodigo.validator.enumeration.CustomerType;
import com.mikkaeru.casadocodigo.validator.existsId.ExistsId;
import com.mikkaeru.casadocodigo.validator.group.CnpjGroup;
import com.mikkaeru.casadocodigo.validator.group.CpfGroup;
import com.mikkaeru.casadocodigo.validator.group.CustomerGroupSequenceProvider;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@GroupSequenceProvider(CustomerGroupSequenceProvider.class)
public class CustomerRequest {

    @Email
    @NotBlank
    @UniqueValue(fieldName = "email", domainClass = Customer.class)
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    @UniqueValue(fieldName = "document", domainClass = Customer.class)
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotBlank
    private String city;

    @NotBlank
    private String phone;

    @NotBlank
    private String cep;

    @NotNull
    @ExistsRelationship(
            fieldName = "country",
            domainClass = Country.class,
            relationshipClass = State.class)
    private long countryId;

    @NotNull
    @ExistsId(domainClass = State.class, fieldName = "id")
    private long stateId;

    @NotNull
    private CustomerType customerType;

    public CustomerRequest(@Email @NotBlank String email, @NotBlank String name, @NotBlank String lastname,
                           @CPF(groups = CpfGroup.class) @CNPJ(groups = CnpjGroup.class) @NotBlank String document,
                           @NotBlank String address, @NotBlank String complement, @NotBlank String city, @NotBlank String phone,
                           @NotBlank String cep, @NotNull long countryId, @NotNull long stateId, @NotNull CustomerType customerType) {

        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.phone = phone;
        this.cep = cep;
        this.countryId = countryId;
        this.stateId = stateId;
        this.customerType = customerType;
    }

    public Customer toModel(CountryRepository countryRepository, StateRepository stateRepository) {
        Optional<Country> country = countryRepository.findById(countryId);
        Optional<State> state = stateRepository.findById(stateId);

        if (country.isEmpty() || state.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return new Customer(
                email, name, lastname, document, address, complement,
                city, phone, cep, country.get(), state.get(), customerType
        );
    }

    public CustomerType getCustomerType() {
        return customerType;
    }
}
