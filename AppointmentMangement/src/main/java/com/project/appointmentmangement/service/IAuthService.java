package com.project.appointmentmangement.service;

import com.project.appointmentmangement.dto.request.AuthLoginRequestDto;
import com.project.appointmentmangement.dto.response.AuthLoginResponseDto;

public interface IAuthService {
    AuthLoginResponseDto login(AuthLoginRequestDto authLoginRequestDto);
}
