package com.mikkaeru.casadocodigo.repository;

import com.mikkaeru.casadocodigo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
