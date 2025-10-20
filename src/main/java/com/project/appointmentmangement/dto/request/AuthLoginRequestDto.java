package com.project.appointmentmangement.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthLoginRequestDto(

        @NotBlank(message = "El correo es requerido")
        @Email(message = "Ingrese un correo, correcto¡")
        String email,

        @NotBlank(message = "La contraseña es requerido")
        @Size(min = 8, message = "La contraseña tiene que tener minímo 8 caracteres")
        String password) {
}
