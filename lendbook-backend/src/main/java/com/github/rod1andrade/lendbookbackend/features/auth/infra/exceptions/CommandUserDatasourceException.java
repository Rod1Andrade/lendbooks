package com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions;

public class CommandUserDatasourceException extends RuntimeException {
    public CommandUserDatasourceException() {
        super();
    }

    public CommandUserDatasourceException(String message) {
        super(message);
    }
}
