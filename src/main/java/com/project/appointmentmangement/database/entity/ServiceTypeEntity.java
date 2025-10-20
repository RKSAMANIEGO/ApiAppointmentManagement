package com.project.appointmentmangement.database.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "service_types")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTypeEntity {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @Column(name = "service_type", length = 50, nullable = false)
    private String serviceType;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @OneToMany(mappedBy = "serviceType")
    private List<ServiceTypeEntity> services = new ArrayList<>();
}
