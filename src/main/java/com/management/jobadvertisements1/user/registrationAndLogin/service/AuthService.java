package com.management.jobadvertisements1.user.registrationAndLogin.service;

import com.management.jobadvertisements1.user.registrationAndLogin.model.LoginResponse;
import com.management.jobadvertisements1.security.JwtIssuer;
import com.management.jobadvertisements1.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;

    private final AuthenticationManager authenticationManager;


    public LoginResponse attempt (String email, String password) {

        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var principal = (UserPrincipal) authentication.getPrincipal();

        var token = jwtIssuer.issuer(principal.getEmail(), principal.getUsername());

        return LoginResponse.builder()
                .token(token)
                .build();

    }
}
