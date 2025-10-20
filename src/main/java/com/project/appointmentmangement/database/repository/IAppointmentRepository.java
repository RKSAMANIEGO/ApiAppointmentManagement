package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IAppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
}
