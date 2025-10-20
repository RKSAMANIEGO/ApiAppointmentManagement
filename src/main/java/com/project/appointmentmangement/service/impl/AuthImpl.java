package com.project.appointmentmangement.service.impl;

import com.project.appointmentmangement.database.entity.ProfileUserEntity;
import com.project.appointmentmangement.database.entity.UserRolesEntity;
import com.project.appointmentmangement.database.repository.IProfileRepository;
import com.project.appointmentmangement.database.repository.IProfileUserRepository;
import com.project.appointmentmangement.database.repository.IUserRepository;
import com.project.appointmentmangement.database.repository.IUserRolesRepository;
import com.project.appointmentmangement.dto.request.AuthRegisterRequestDto;
import com.project.appointmentmangement.dto.response.AuthLoginResponseDto;
import com.project.appointmentmangement.dto.request.AuthLoginRequestDto;
import com.project.appointmentmangement.database.entity.ProfileEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.project.appointmentmangement.database.entity.UserEntity;
import com.project.appointmentmangement.dto.mapper.UserMapper;
import com.project.appointmentmangement.security.jwt.JwtUtils;
import com.project.appointmentmangement.service.IAuthService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final IProfileUserRepository  profileUserRepository;
    private final IUserRolesRepository  userRolesRepository;
    private final IProfileRepository  profileRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtils jwtUtils;

    @Override
    public AuthLoginResponseDto login(AuthLoginRequestDto authLoginRequestDto) {
        try{
            Authentication auth = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authLoginRequestDto.email(), authLoginRequestDto.password()));
            Set<String> roles = auth.getAuthorities().stream().filter(r -> r.getAuthority().startsWith("ROLE")).map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
            String token = jwtUtils.generatedToken(authLoginRequestDto.email());
            return new AuthLoginResponseDto("Authentication Successfulled",roles,authLoginRequestDto.email(), token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, String> register(AuthRegisterRequestDto authRegisterRequestDto) {
        validatePasswordEmailOrUsername(authRegisterRequestDto);
        UserEntity user = userEntity(authRegisterRequestDto);
        user.setRoles(rolesByDefault(user));
        return Map.of("Message","Register Successful");
    }

    private List<UserRolesEntity> rolesByDefault( UserEntity user ){
        List<UserRolesEntity> roles = userMapper.defaultRoles(user);
        return userRolesRepository.saveAll(roles);
    }

    private UserEntity userEntity(AuthRegisterRequestDto authRegisterRequestDto){
        UserEntity user =userMapper.dtoReqToUserEntity(authRegisterRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setProfile(profileEntity(authRegisterRequestDto));
        return userRepository.save(user);
    }

    private ProfileEntity profileEntity(AuthRegisterRequestDto authRegisterRequestDto){
        ProfileUserEntity profileUser = saveProfileUser(authRegisterRequestDto);
        return profileRepository.findById(profileUser.getId()).orElseThrow(()->new IllegalArgumentException("Error, Profile User not found!"));
    }

    private ProfileUserEntity saveProfileUser(AuthRegisterRequestDto authRegisterRequestDto){
        ProfileUserEntity profileUserEntity =new ProfileUserEntity();
        profileUserEntity.setName(authRegisterRequestDto.firstName());
        profileUserEntity.setLastname(authRegisterRequestDto.lastName());
        return profileUserRepository.save(profileUserEntity);
    }

    private void validatePasswordEmailOrUsername(AuthRegisterRequestDto authRegisterRequestDto){
        if(!authRegisterRequestDto.password().equals(authRegisterRequestDto.confirmPassword())){
            throw new IllegalArgumentException("Passwords do not match");
        }
        if(userRepository.findByEmail(authRegisterRequestDto.email()).isPresent()){
            throw new IllegalArgumentException("Error, Email is Exist!");
        }
        if(userRepository.findByUsername(authRegisterRequestDto.username()).isPresent()){
            throw new IllegalArgumentException("Error, Username is Exist!");
        }
    }


}
