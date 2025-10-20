package com.project.appointmentmangement.service.impl;

import com.project.appointmentmangement.database.repository.IProfileUserRepository;
import com.project.appointmentmangement.database.repository.IProfileRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.project.appointmentmangement.database.repository.IUserRepository;
import com.project.appointmentmangement.database.entity.ProfileUserEntity;
import com.project.appointmentmangement.dto.request.ProfileUserUpdateDto;
import com.project.appointmentmangement.dto.response.ProfileResponseDto;
import com.project.appointmentmangement.database.entity.ProfileEntity;
import com.project.appointmentmangement.dto.response.SaveResponseDto;
import com.project.appointmentmangement.database.entity.UserEntity;
import com.project.appointmentmangement.dto.mapper.ProfileMapper;
import com.project.appointmentmangement.service.IProfileService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileImpl implements IProfileService {

    private final IProfileUserRepository profileUserRepository;
    private final IProfileRepository profileRepository;
    private final IUserRepository userRepository;
    private final ProfileMapper profileMapper;

    @Override
    public ProfileResponseDto getProfile(Authentication authentication) {
        UserEntity userFound = userRepository.findByEmail(authentication.getName()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return profileMapper.profileEntityToDto(userFound.getProfile());
    }

    @Override
    public SaveResponseDto updateProfileUser(ProfileUserUpdateDto profile) {
        ProfileEntity profileFound =profileRepository.findById(profile.id()).orElseThrow(() -> new IllegalArgumentException("Profile not found!"));
        if(!(profileFound instanceof  ProfileUserEntity))  throw new RuntimeException("User not found");
        profileMapper.updateDtoToProfileUserEntity((ProfileUserEntity) profileFound,profile);
        profileRepository.save(profileFound);
        return SaveResponseDto.builder().id(profileFound.getId()).message("Profile user updated successfully¡").build();
    }
}