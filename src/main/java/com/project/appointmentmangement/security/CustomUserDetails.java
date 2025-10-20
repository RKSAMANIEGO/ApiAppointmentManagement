package com.project.appointmentmangement.security;

import com.project.appointmentmangement.database.entity.RolPermissionEntity;
import com.project.appointmentmangement.database.entity.UserEntity;
import com.project.appointmentmangement.database.entity.UserRolesEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {

    private final UserEntity userEntity;

    public CustomUserDetails(UserEntity userEntity){
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(UserRolesEntity role: userEntity.getRoles() ){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole().getRoleName()));
            for(RolPermissionEntity permission : role.getRole().getPermissions()){
                authorities.add(new SimpleGrantedAuthority(permission.getPermission().getName()));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEntity.getIsEnabled();
    }
}
