package com.project.appointmentmangement.database.entity;
import com.project.appointmentmangement.database.enumerated.EnumState;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "services")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type_id")
    private ServiceTypeEntity serviceType;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 255, nullable = true)
    private String description;

    @Column(name = "duration_attention")
    private Integer durationAttention;

    private Double price;

    @Enumerated(EnumType.STRING)
    private EnumState state;

    @OneToMany(mappedBy = "service")
    private List<AppointmentServicesEntity>  appointmentServices;
}
