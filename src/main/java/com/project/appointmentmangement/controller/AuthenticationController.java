package com.project.appointmentmangement.controller;

import com.project.appointmentmangement.dto.request.AuthRegisterRequestDto;
import com.project.appointmentmangement.dto.response.AuthLoginResponseDto;
import com.project.appointmentmangement.dto.request.AuthLoginRequestDto;
import com.project.appointmentmangement.service.IAuthService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final IAuthService authService;

    @PostMapping("/log-in")
    public ResponseEntity<AuthLoginResponseDto> logIn(@RequestBody AuthLoginRequestDto credentials) {
        return ResponseEntity.ok().body(authService.login(credentials));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRegisterRequestDto authRegisterRequestDto) {
        return ResponseEntity.ok().body(authService.register(authRegisterRequestDto));
    }
}
