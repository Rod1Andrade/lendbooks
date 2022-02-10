package com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions;

/**
 * @author Rodrigo Andrade
 */
public class InvalidUserExcepetion extends RuntimeException {
    public InvalidUserExcepetion() {
        super();
    }

    public InvalidUserExcepetion(String message) {
        super(message);
    }
}
