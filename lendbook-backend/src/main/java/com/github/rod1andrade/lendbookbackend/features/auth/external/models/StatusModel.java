package com.github.rod1andrade.lendbookbackend.features.auth.external.models;

import com.github.rod1andrade.lendbookbackend.features.auth.external.enums.UserModelStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = "tb_user_status")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StatusModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Builder.Default
    private UserModelStatus status = UserModelStatus.UNACTIVATE;

    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private Instant createAt;

    @Getter
    @Setter
    private Instant expiryTime;

    @OneToOne(mappedBy = "statusModel")
    @Getter
    @Setter
    private UserModel userModel;
}
