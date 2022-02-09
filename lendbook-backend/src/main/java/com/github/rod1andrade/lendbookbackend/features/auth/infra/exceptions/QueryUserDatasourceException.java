package com.github.rod1andrade.lendbookbackend.features.auth.infra.exceptions;

public class QueryUserDatasourceException extends RuntimeException{
    public QueryUserDatasourceException() {
        super();
    }

    public QueryUserDatasourceException(String message) {
        super(message);
    }
}
