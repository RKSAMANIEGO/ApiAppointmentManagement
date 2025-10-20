package com.project.appointmentmangement.database.entity;
import jakarta.persistence.*;
import java.util.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name="profiles")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class ProfileEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    @GeneratedValue
    private UUID id;

    @OneToOne(mappedBy = "profile")
    private UserEntity user;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String lastname;

    @Column(length = 15)
    private String phone;

    @Column(name="is_enabled")
    @Builder.Default
    private Boolean isEnabled = true;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<PetEntity> pets = new ArrayList<>();

    @OneToMany(mappedBy = "veterinarian")
    private List<AppointmentEntity> appointments= new ArrayList<>();
}
/*

@Entity
@Table(name="profiles")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @OneToOne(mappedBy = "profile")
    private UserEntity user;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String lastname;

    @Column(length = 100, nullable = true)
    private String specialty;

    @Column(length = 100, nullable = true)
    private String experience;

    @Column(length = 15, nullable = true)
    private String phone;

    @Column(name="is_enabled")
    private Boolean isEnabled;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<PetEntity> pets = new ArrayList<>();

    @OneToMany(mappedBy = "veterinarian")
    private List<AppointmentEntity> appointments= new ArrayList<>();
}
 */