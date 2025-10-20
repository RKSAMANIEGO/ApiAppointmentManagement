package com.project.appointmentmangement.database.entity;
import com.project.appointmentmangement.database.enumerated.EnumState;
import jakarta.persistence.*;
import java.util.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;

@Entity
@Table(name = "pets")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duenio_id")
    private ProfileEntity profile;

    @Column(length = 60)
    private String name;

    @Column(length = 60)
    private String race;

    @Column(length = 60)
    private String genre;

    private Integer age;

    @Column(name="registry_datetime")
    private LocalDateTime registryDatetime;

    @Enumerated(EnumType.STRING)
    private EnumState state;

    private Boolean isEnabled;

    @OneToMany(mappedBy = "pet")
    private List<MedicalRecordEntity> medicalRecords = new ArrayList<>();

    @OneToMany(mappedBy = "pet")
    private List<AppointmentEntity> appointments = new ArrayList<>();
}
