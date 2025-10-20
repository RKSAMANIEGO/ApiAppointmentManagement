package com.project.appointmentmangement.database.repository;

import com.project.appointmentmangement.database.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IRecipeRepository extends JpaRepository<RecipeEntity, UUID> {
}
