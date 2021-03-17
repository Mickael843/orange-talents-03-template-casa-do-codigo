package com.mikkaeru.casadocodigo.repository;

import com.mikkaeru.casadocodigo.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}
