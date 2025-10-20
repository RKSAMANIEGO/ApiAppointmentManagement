package com.project.appointmentmangement.database.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import java.util.*;



@Entity
@Table(name = "medical_records_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordDetailsEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "medical_record_id")
    private MedicalRecordEntity medicalRecord;

    @Column(name = "registry_datetime")
    private LocalDateTime registryDatetime;

    @Column(length = 255, nullable = true)
    private String diagnosis;

    @Column(length = 255, nullable = false)
    private String reason;

    @Column(length = 255, nullable = true)
    private String treatment;

    @OneToMany(mappedBy = "medicalRecordDetails")
    private List<RecipeEntity> recipes = new ArrayList<>();
}
