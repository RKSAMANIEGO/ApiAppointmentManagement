package com.project.appointmentmangement.dto.response;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthLoginResponseDto {
    String message;
    Set<String> roles;
    String email;
    String token;
}
