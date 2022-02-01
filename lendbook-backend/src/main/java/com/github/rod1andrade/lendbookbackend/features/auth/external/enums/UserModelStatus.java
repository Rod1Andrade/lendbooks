package com.github.rod1andrade.lendbookbackend.features.auth.external.enums;

import java.util.Arrays;

public enum UserModelStatus {
    UNACTIVATE(1),
    ACTIVATE(2);

    private final int code;

    UserModelStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserModelStatus valueOf(int code) {
        return Arrays.stream(values()).filter(v -> v.getCode() == code).findFirst().get();
    }
}
