package com.project.appointmentmangement.dto.response;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthLoginResponseDto {
    String message;
    String email;
    String token;
}
