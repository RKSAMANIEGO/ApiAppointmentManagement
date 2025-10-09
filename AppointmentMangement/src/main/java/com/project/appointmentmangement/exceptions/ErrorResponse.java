package com.project.appointmentmangement.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private int codeStatus;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, HttpStatus codeStatus){
        this.message=message;
        this.codeStatus=codeStatus.value();
        timestamp= LocalDateTime.now();
    }

}
