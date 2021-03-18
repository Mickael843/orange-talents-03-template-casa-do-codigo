package com.mikkaeru.casadocodigo.validator.enumeration;

import com.mikkaeru.casadocodigo.validator.group.CnpjGroup;
import com.mikkaeru.casadocodigo.validator.group.CpfGroup;

public enum CustomerType {

    FISICA("Física", "CPF", "000.000.000-00", CpfGroup.class),
    JURIDICA("Jurídica", "CNPJ", "00.000.000/0000-00", CnpjGroup.class);

    private final String description;
    private final String document;
    private final String mascara;
    private final Class<?> group;

    CustomerType(String description, String document, String mascara, Class<?> group) {
        this.description = description;
        this.document = document;
        this.mascara = mascara;
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public String getDocument() {
        return document;
    }

    public String getMascara() {
        return mascara;
    }

    public Class<?> getGroup() {
        return group;
    }
}
