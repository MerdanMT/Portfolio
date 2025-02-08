package com.management.jobadvertisements1.registrationAndLogin.controller;

import com.management.jobadvertisements1.registrationAndLogin.model.LoginRequest;
import com.management.jobadvertisements1.registrationAndLogin.model.LoginResponse;
import com.management.jobadvertisements1.registrationAndLogin.model.RegisterRequest;
import com.management.jobadvertisements1.registrationAndLogin.service.AuthService;
import com.management.jobadvertisements1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userServices;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Validated RegisterRequest registerRequest) {
        try {
            userServices.registerUser(registerRequest);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) {

        return userServices.loginUser(loginRequest);
    }

}
