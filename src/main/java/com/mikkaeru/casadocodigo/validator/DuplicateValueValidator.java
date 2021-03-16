package com.mikkaeru.casadocodigo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class DuplicateValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private Class<?> aClass;
    private String domainAttribute;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.aClass = constraintAnnotation.domainClass();
        this.domainAttribute = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String[] tmp = aClass.getName().split("\\.");
        String klassName = tmp[tmp.length - 1].toLowerCase(Locale.ROOT);

        String sql = "SELECT * FROM " + klassName + " WHERE " + domainAttribute + "=" + "'" +value+ "'";

        List<String> list = jdbcTemplate.query(sql, rs -> {

            List<String> listTmp = new ArrayList<>();

            while (rs.next()) {

                var field = rs.getString(domainAttribute);

                listTmp.add(field);

            }

            return listTmp;
        });

        assert list != null;
        Assert.state(list.size() <= 1, "Foi encontrado mais de um " + aClass + " com o atributo " + domainAttribute+" = " + value);

        return list.isEmpty();
    }
}
