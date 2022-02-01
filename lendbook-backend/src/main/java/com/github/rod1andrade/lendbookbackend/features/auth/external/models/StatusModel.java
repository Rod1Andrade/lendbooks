package com.github.rod1andrade.lendbookbackend.features.auth.external.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.rod1andrade.lendbookbackend.features.auth.external.enums.UserModelStatus;
import com.sun.source.doctree.InlineTagTree;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = "tb_user_status")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatusModel  implements Serializable {

    private static final long TOKEN_LIMIT_TIME_IN_SECONDS = 1000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private UserModelStatus status = UserModelStatus.UNACTIVATE;

    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private Instant createAt = Instant.now();

    @Getter
    @Setter
    private Instant expiryTime = Instant.now().plusSeconds(TOKEN_LIMIT_TIME_IN_SECONDS);

    @OneToOne(mappedBy = "statusModel")
    @Getter
    @Setter
    private UserModel userModel;
}
