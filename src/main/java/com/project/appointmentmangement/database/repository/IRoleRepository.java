package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface IRoleRepository extends JpaRepository<RoleEntity, UUID> {
    Optional<RoleEntity> findByRoleName(String name);
}
