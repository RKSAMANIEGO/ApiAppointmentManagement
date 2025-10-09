package com.project.appointmentmangement.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.*;


@Entity()
@Table(name="appointment_services")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentServicesEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="service_id")
    private ServiceEntity service ;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private AppointmentEntity appointment;


    

}
