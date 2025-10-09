package com.project.appointmentmangement.security.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.FilterChain;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class FilterAuthentication extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserDetailsService  userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            final String tokenHeader = request.getHeader("Authorization");
            if(tokenHeader != null && tokenHeader.startsWith("Bearer ")){
                String token = tokenHeader.substring(7);
                String username = jwtUtils.getSubjectFromToken(token);
                if(jwtUtils.isTokenExpired(token,username)  && SecurityContextHolder.getContext().getAuthentication() == null){
                   UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                   Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());

                   SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }catch (Exception ex){
            log.error("Error authentication: {}",ex.getMessage(),ex);
        }
        filterChain.doFilter(request,response);
    }
}
