package com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions;

public class DispatchConfirmMailEventException extends RuntimeException {
    public DispatchConfirmMailEventException() {
        super();
    }

    public DispatchConfirmMailEventException(String message) {
        super(message);
    }
}
