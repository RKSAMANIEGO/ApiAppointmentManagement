package com.project.appointmentmangement.dto.request;
import java.util.UUID;

public record ProfileUserRequestDto(
        String name,
        String lastname,
        String phone,
        String dni,
        String address,
        UUID userId
) { }