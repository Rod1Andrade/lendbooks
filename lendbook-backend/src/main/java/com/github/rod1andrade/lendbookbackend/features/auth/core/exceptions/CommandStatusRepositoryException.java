package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class CommandStatusRepositoryException extends RuntimeException {
    public CommandStatusRepositoryException() {
        super();
    }

    public CommandStatusRepositoryException(String message) {
        super(message);
    }
}
