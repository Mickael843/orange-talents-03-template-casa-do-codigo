package com.mikkaeru.casadocodigo.repository;

import com.mikkaeru.casadocodigo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
