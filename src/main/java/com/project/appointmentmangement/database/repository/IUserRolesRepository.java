package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.UserRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRolesRepository extends JpaRepository<UserRolesEntity, UUID> {
}
