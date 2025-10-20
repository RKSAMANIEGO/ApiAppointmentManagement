package com.project.appointmentmangement.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "profiles_user")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUserEntity extends ProfileEntity {

    @Column(length = 15, nullable = true)
    private String dni;

    @Column(length = 255, nullable = true)
    private String address;
}
