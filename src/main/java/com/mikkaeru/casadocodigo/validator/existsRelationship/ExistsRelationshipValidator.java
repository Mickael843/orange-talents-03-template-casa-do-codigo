package com.mikkaeru.casadocodigo.validator.existsRelationship;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsRelationshipValidator implements ConstraintValidator<ExistsRelationship, Object> {

    private String fieldName;
    private Class<?> domainClass;
    private Class<?> relationshipClass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsRelationship constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.domainClass = constraintAnnotation.domainClass();
        this.relationshipClass = constraintAnnotation.relationshipClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("SELECT t1 FROM " +domainClass.getName()+
                " t1 INNER JOIN " +relationshipClass.getName()+ " t2 ON t1.id = t2." +fieldName+ " WHERE t1.id=" +value);

        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}
