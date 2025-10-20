package com.project.appointmentmangement.dto.mapper;
import com.project.appointmentmangement.database.repository.IRoleRepository;
import com.project.appointmentmangement.dto.request.AuthRegisterRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.appointmentmangement.database.entity.*;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class  UserMapper {

    @Autowired
    private IRoleRepository roleRepository;

     public abstract UserEntity dtoReqToUserEntity(AuthRegisterRequestDto requestDto);

     public List<UserRolesEntity> defaultRoles(UserEntity userEntity){
         RoleEntity roleDefault =roleRepository.findByRoleName("USER").orElseThrow(()-> new EntityNotFoundException("Role not found"));
         return List.of(UserRolesEntity.builder().user(userEntity).role(roleDefault).build());
     }
}
