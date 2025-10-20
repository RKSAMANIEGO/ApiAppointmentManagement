package com.project.appointmentmangement.dto.response;
import lombok.Data;
import java.util.UUID;

@Data
public class ProfileResponseDto{
    private UUID id;
    private String name;
    private String lastname;
    private String phone;
    private String dni;
    private String address;
    private String specialty;
    private String experience;
}
