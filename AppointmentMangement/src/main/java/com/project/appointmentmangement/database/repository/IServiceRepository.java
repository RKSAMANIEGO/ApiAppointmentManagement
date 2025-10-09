package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IServiceRepository extends JpaRepository<ServiceEntity, UUID> {
}
