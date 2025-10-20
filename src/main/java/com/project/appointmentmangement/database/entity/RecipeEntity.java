package com.project.appointmentmangement.database.entity;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "recipes")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private AppointmentEntity appointment;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "medical_record_details_id")
    private MedicalRecordDetailsEntity medicalRecordDetails;

    private LocalDateTime datetime;

    @Column(length = 255, nullable = true)
    private String description;

    @Column(length = 255, nullable = true)
    private String medications;
}
