package com.github.rod1andrade.lendbookbackend.features.mail.infra.exceptions;

public class DispatchMailEventException extends RuntimeException {
    public DispatchMailEventException() {
        super();
    }

    public DispatchMailEventException(String message) {
        super(message);
    }
}
