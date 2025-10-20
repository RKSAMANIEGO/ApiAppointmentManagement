package com.project.appointmentmangement.dto.request;

public record AuthRegisterRequestDto (
         String firstName,
         String lastName,
         String username,
         String email,
         String password,
         String confirmPassword
) {
}
