package com.aprendizado.praticarmuito.service.exceptions;

// caso especial de violação de integridade de banco de dados por tentar excluir um user que contem dados de outras classes

public class DataBaseException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public DataBaseException(String msg) {
        super(msg);
    }
}
