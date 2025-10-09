package com.project.appointmentmangement.service.impl;

import com.project.appointmentmangement.dto.response.AuthLoginResponseDto;
import com.project.appointmentmangement.dto.request.AuthLoginRequestDto;
import com.project.appointmentmangement.security.UserDetailsServiceImpl;
import com.project.appointmentmangement.security.jwt.JwtUtils;
import com.project.appointmentmangement.service.IAuthService;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import lombok.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthImpl implements IAuthService {
    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthLoginResponseDto login(AuthLoginRequestDto authLoginRequestDto) {
        try{
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authLoginRequestDto.email(), authLoginRequestDto.password()));
            userDetailsService.loadUserByUsername(authLoginRequestDto.email());
            String token = jwtUtils.generatedToken(authLoginRequestDto.email());
            return new AuthLoginResponseDto("Authentication Successfulled",authLoginRequestDto.email(), token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
