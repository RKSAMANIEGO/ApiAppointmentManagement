package com.project.appointmentmangement.database.repository;
import com.project.appointmentmangement.database.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IPetRepository extends JpaRepository<PetEntity, UUID> {
}
