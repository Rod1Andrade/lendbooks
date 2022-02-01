package com.github.rod1andrade.lendbookbackend.features.auth.core.enums;

public enum UserStatus {
    UNACTIVATE(1),
    ACTIVATE(2);

    private final int code;

    UserStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
