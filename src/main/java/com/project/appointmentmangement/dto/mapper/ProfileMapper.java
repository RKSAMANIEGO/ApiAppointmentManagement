package com.project.appointmentmangement.dto.mapper;

import com.project.appointmentmangement.database.repository.IUserRepository;
import com.project.appointmentmangement.database.entity.ProfileUserEntity;
import com.project.appointmentmangement.dto.request.ProfileUserUpdateDto;
import com.project.appointmentmangement.dto.response.ProfileResponseDto;
import com.project.appointmentmangement.database.entity.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class ProfileMapper {

    @Autowired
    private IUserRepository userRepository;

    public abstract ProfileResponseDto profileEntityToDto(ProfileEntity profileEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateDtoToProfileUserEntity(@MappingTarget ProfileUserEntity profileUserEntity, ProfileUserUpdateDto profileUserRequestDto);
}
