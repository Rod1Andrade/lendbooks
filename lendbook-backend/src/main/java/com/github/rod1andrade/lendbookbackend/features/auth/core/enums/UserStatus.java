package com.github.rod1andrade.lendbookbackend.features.auth.core.enums;

import com.github.rod1andrade.lendbookbackend.features.auth.external.enums.UserModelStatus;

import java.util.Arrays;

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

    public static UserStatus valueOf(int code) {
        return Arrays.stream(values()).filter(v -> v.getCode() == code).findFirst().get();
    }
}
