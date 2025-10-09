package com.project.appointmentmangement.dto.response;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveResponseDto {
    private UUID id;
    private String message;
}
