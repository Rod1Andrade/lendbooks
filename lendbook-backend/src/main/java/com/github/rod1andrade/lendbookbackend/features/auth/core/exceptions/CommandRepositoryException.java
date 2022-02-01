package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class CommandRepositoryException extends RuntimeException {
    public CommandRepositoryException() {
        super();
    }

    public CommandRepositoryException(String message) {
        super(message);
    }
}
