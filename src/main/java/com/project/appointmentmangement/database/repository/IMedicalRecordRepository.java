package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.MedicalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IMedicalRecordRepository extends JpaRepository<MedicalRecordEntity, UUID> {
}
