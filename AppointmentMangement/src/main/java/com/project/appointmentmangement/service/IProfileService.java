package com.project.appointmentmangement.service;
import com.project.appointmentmangement.dto.request.ProfileUserUpdateDto;
import com.project.appointmentmangement.dto.response.ProfileResponseDto;
import com.project.appointmentmangement.dto.response.SaveResponseDto;
import org.springframework.security.core.Authentication;

public interface IProfileService {
    ProfileResponseDto getProfile(Authentication authentication);
    SaveResponseDto updateProfileUser(ProfileUserUpdateDto profile);
}
