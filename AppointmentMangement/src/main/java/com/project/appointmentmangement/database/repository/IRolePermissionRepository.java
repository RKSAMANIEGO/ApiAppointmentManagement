package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.RolPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRolePermissionRepository extends JpaRepository<RolPermissionEntity, UUID> {
}
