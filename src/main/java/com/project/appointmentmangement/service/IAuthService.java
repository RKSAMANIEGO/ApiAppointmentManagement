package com.project.appointmentmangement.service;

import com.project.appointmentmangement.dto.request.AuthLoginRequestDto;
import com.project.appointmentmangement.dto.request.AuthRegisterRequestDto;
import com.project.appointmentmangement.dto.response.AuthLoginResponseDto;

import java.util.Map;

public interface IAuthService {
    AuthLoginResponseDto login(AuthLoginRequestDto authLoginRequestDto);
    Map<String,String> register(AuthRegisterRequestDto authRegisterRequestDto);
}
