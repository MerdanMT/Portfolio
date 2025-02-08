package com.management.jobadvertisements1.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtIssuer {

    private final JwtProperties jwtProperties;

    public String issuer(String email, String password) {

        return JWT.create()
                .withClaim("email", email)
                .withClaim("password", password)
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));

    }
}
