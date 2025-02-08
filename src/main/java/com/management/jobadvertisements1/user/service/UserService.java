package com.management.jobadvertisements1.user.service;

import com.management.jobadvertisements1.registrationAndLogin.model.LoginRequest;
import com.management.jobadvertisements1.registrationAndLogin.model.LoginResponse;
import com.management.jobadvertisements1.registrationAndLogin.model.RegisterRequest;
import com.management.jobadvertisements1.user.dto.request.UserCreateRequestDto;
import com.management.jobadvertisements1.user.dto.request.UserUpdateRequestDto;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.entity.User;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface UserService {

    void addUser(UserCreateRequestDto userCreateRequestDto);

    void updateUser(Long id, UserUpdateRequestDto updateRequestDto);

    void deleteUser(Long id);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();

    String getAllMyWorkplaces(Long id);

    void getUserByActivateOnOff(Long id,String string);

    List<UserResponseDto> getAllUsersActivate();

    List<UserResponseDto> getAllUsersByRegion(String region);

    User getUserByEmail(String email);

    void registerUser(RegisterRequest registerRequest);

    LoginResponse loginUser(LoginRequest loginRequest);

}
