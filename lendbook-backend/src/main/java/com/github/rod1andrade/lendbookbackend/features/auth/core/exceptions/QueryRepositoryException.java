package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class QueryRepositoryException extends RuntimeException{
    public QueryRepositoryException() {
        super();
    }

    public QueryRepositoryException(String message) {
        super(message);
    }
}
