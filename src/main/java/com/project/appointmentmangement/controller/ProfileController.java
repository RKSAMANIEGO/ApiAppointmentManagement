package com.project.appointmentmangement.controller;

import com.project.appointmentmangement.dto.request.ProfileUserUpdateDto;
import com.project.appointmentmangement.service.IProfileService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final IProfileService profileService;

    @GetMapping("/getProfile")
    public ResponseEntity<?> getProfile(Authentication auth){
        return ResponseEntity.ok().body(profileService.getProfile(auth));
    }

    @PatchMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateProfileUser(@RequestBody ProfileUserUpdateDto profileUserRequestDto) {
        return ResponseEntity.ok().body(profileService.updateProfileUser(profileUserRequestDto));
    }


}
