package com.github.rod1andrade.lendbookbackend.features.auth.external.models;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private UUID uuid;

    @Getter
    @Setter
    @NonNull
    private String name;

    @Getter
    @Setter
    @NonNull
    private String lastName;

    @Getter
    @Setter
    @NonNull
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    @NonNull
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    @Getter
    @Setter
    private StatusModel statusModel;
}
