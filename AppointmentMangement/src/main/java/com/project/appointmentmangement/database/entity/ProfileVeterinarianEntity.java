package com.project.appointmentmangement.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "profiles_veterinarian")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileVeterinarianEntity extends ProfileEntity{

//    @Id
//    private UUID id;

    @Column(length = 100)
    private String specialty;

    private String experience;
}
