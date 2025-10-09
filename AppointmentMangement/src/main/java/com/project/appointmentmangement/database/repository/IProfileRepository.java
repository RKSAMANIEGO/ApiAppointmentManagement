package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IProfileRepository extends JpaRepository<ProfileEntity , UUID> {

}
