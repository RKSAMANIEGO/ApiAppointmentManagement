package com.project.appointmentmangement.database.entity;
import com.project.appointmentmangement.database.enumerated.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
import lombok.*;

@Entity
@Table(name = "appointment")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinarian_id")
    private ProfileEntity veterinarian;

    @Column(name="appointment_datetime")
    private LocalDateTime appointmentDatetime;

    @Column(length = 255, nullable = false)
    private String reason;

    @Column(length =  255, nullable = false)
    private String ubication;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_type")
    private EnumModalityAppointment appointmentType;

    @Enumerated(EnumType.STRING)
    private EnumStateAppointment state;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @OneToMany(mappedBy = "appointment")
    private List<RecipeEntity> recipes;

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentServicesEntity> appointmentServices;
}
