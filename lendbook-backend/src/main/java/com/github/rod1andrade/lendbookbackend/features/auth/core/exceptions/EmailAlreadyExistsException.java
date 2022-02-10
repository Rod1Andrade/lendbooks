package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

public class EmailAlreadyExistsException extends InvalidUserExcepetion{
    public EmailAlreadyExistsException() {
        super();
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
