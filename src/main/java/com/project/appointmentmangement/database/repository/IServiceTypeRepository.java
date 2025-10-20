package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.ServiceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IServiceTypeRepository extends JpaRepository<ServiceTypeEntity, UUID> {
}
