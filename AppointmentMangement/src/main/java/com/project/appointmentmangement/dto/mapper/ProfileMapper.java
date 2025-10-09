package com.project.appointmentmangement.dto.mapper;

import com.project.appointmentmangement.database.repository.IUserRepository;
import com.project.appointmentmangement.database.entity.ProfileUserEntity;
import com.project.appointmentmangement.dto.request.ProfileUserUpdateDto;
import com.project.appointmentmangement.dto.response.ProfileResponseDto;
import com.project.appointmentmangement.database.entity.ProfileEntity;
import com.project.appointmentmangement.database.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.*;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class ProfileMapper {

    @Autowired
    private IUserRepository userRepository;

    public abstract ProfileResponseDto profileEntityToDto(ProfileEntity profileEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateDtoToProfileUserEntity(@MappingTarget ProfileUserEntity profileUserEntity, ProfileUserUpdateDto profileUserRequestDto);

    @Named("mapUserId")
    private UserEntity mapUserId(UUID userId) {
        if (userId == null  ) return null;
        return userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User not found"));
    }

}
