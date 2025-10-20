package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.ProfileUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProfileUserRepository extends JpaRepository<ProfileUserEntity, UUID> {
}
