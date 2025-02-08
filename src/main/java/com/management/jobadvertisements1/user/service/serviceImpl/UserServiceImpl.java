package com.management.jobadvertisements1.user.service.serviceImpl;

import com.management.jobadvertisements1.registrationAndLogin.model.LoginRequest;
import com.management.jobadvertisements1.registrationAndLogin.model.LoginResponse;
import com.management.jobadvertisements1.registrationAndLogin.model.RegisterRequest;
import com.management.jobadvertisements1.security.JwtIssuer;
import com.management.jobadvertisements1.user.dto.request.UserCreateRequestDto;
import com.management.jobadvertisements1.user.dto.request.UserUpdateRequestDto;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.entity.User;
import com.management.jobadvertisements1.user.mapper.UserMapper;
import com.management.jobadvertisements1.user.repository.UserRepository;
import com.management.jobadvertisements1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtIssuer jwtIssuer;


    @Override
    public void addUser(UserCreateRequestDto userCreateRequestDto) {

        userRepository.save(userMapper.toUser(userCreateRequestDto));

    }

    @Override
    public void updateUser(Long id, UserUpdateRequestDto updateRequestDto) {

        User user = userRepository.findById(id).orElse(null);

        userRepository.save(userMapper.toUser(user, updateRequestDto));
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto getUserById(Long id) {

        return userMapper.toUserResponseDto(userRepository.findById(id).orElse(null));
    }

    @Override
    public List<UserResponseDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        for (User user : users) {
            userResponseDtos.add(userMapper.toUserResponseDto(user));
        }

        return userResponseDtos;
    }

    @Override
    public String getAllMyWorkplaces(Long id) {

        User user = userRepository.findById(id).orElse(null);

        assert user != null;

        return user.getMyWorkplaces();
    }

    @Override
    public void getUserByActivateOnOff(Long id,String string) {

        User user = userRepository.findById(id).orElse(null);

        if("ok".equals(string)) {
            if (user != null) {
                user.setIsActive(!user.getIsActive());
                userRepository.save(user);
            }
        }
    }

    @Override
    public List<UserResponseDto> getAllUsersActivate() {

        List<User> users = userRepository.getUsersByIsActiveTrue();

        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user : users) {
            userResponseDtos.add(userMapper.toUserResponseDto(user));
        }
        return userResponseDtos;
    }

    @Override
    public List<UserResponseDto> getAllUsersByRegion(String region) {

        List<User> users = userRepository.getUsersByRegionLikeIgnoreCase(region);
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user : users) {
            userResponseDtos.add(userMapper.toUserResponseDto(user));
        }
        return userResponseDtos;
    }

    @Override
    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public void registerUser(RegisterRequest registerRequest) {

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }


        User userEntity= new User();
        userEntity.setEmail(registerRequest.getEmail());

        var token = jwtIssuer.issuer(registerRequest.getEmail(), registerRequest.getPassword());
        userEntity.setPassword(token);


        userRepository.save(userEntity);

    }

    public LoginResponse loginUser(LoginRequest loginRequest) {

        User userEntity = userRepository.findByEmail(loginRequest.getEmail());

        var token = jwtIssuer.issuer(loginRequest.getEmail(), loginRequest.getPassword());

        if (token.equalsIgnoreCase(userEntity.getPassword())) {

            return LoginResponse
                    .builder()
                    .token(token)
                    .build();
        }
        else throw new IllegalArgumentException("Password is incorrect");
    }


}
