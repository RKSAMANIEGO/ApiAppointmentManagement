package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDocumentRepository extends JpaRepository<DocumentEntity, UUID> {
}
