package com.aprendizado.praticarmuito.service.exceptions;

//Criando uma classe que extends um erro do proprio java e pegando o objeto pelo id

public class ResourceNotFoundException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id "+ id);

    }
}
