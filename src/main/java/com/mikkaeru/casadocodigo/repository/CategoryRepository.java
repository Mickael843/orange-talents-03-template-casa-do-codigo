package com.mikkaeru.casadocodigo.repository;

import com.mikkaeru.casadocodigo.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
