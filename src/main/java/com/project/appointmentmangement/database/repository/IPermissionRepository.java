package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IPermissionRepository extends JpaRepository<PermissionEntity, UUID> {
}
