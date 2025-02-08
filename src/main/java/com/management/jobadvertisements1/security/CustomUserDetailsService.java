package com.management.jobadvertisements1.security;

import com.management.jobadvertisements1.user.repository.UserRepository;
import com.management.jobadvertisements1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userServices;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var user = userRepository.findByEmail(email);

        return UserPrincipal.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
