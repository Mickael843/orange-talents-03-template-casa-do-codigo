package com.mikkaeru.casadocodigo.repository;

import com.mikkaeru.casadocodigo.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {
}
