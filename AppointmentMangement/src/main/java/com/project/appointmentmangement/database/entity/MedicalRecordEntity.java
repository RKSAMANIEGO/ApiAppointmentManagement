package com.project.appointmentmangement.database.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.*;

@Entity
@Table(name = "medical_records")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordEntity {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @Column(length = 255, nullable = true)
    private String observation;

    @OneToMany(mappedBy = "medicalRecord")
    private List<MedicalRecordDetailsEntity>  medicalRecordDetails = new ArrayList<>();
}
