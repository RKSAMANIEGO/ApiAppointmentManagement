package com.project.appointmentmangement.security;
import com.project.appointmentmangement.database.repository.IUserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByEmail(username)
                .map(CustomUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("User %s not found", username)  ));
    }
}
