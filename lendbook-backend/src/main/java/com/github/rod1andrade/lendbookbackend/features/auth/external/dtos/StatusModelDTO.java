package com.github.rod1andrade.lendbookbackend.features.auth.external.dtos;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.Status;
import com.github.rod1andrade.lendbookbackend.features.auth.external.enums.UserModelStatus;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.StatusModel;

public class StatusModelDTO {

    private Long id;

    private int code;

    public static StatusModel castStatusToStatusModel (Status status) {
        var statusModel = new StatusModel();
        statusModel.setStatus(UserModelStatus.valueOf(status.getUserStatus().getCode()));
        statusModel.setToken(status.getToken());

        return statusModel;
    }

}
