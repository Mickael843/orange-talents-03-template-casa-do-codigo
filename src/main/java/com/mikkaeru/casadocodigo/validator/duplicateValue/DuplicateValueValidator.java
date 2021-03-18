package com.mikkaeru.casadocodigo.validator.duplicateValue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class DuplicateValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private Class<?> aClass;
    private String domainAttribute;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.aClass = constraintAnnotation.domainClass();
        this.domainAttribute = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("SELECT 1 FROM " + aClass.getName() + " WHERE " +domainAttribute+ "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        return list.isEmpty();
    }
}
