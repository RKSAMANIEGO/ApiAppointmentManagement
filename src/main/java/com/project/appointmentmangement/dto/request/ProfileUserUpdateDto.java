package com.project.appointmentmangement.dto.request;

import java.util.UUID;

public record ProfileUserUpdateDto (
    UUID id,
    String name,
    String lastname,
    String phone,
    String dni,
    String address,
    UUID userId
){}
