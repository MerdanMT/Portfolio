package com.management.jobadvertisements1.user.controller;

import com.management.jobadvertisements1.user.dto.request.UserCreateRequestDto;
import com.management.jobadvertisements1.user.dto.request.UserUpdateRequestDto;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.entity.User;
import com.management.jobadvertisements1.user.mapper.UserMapper;
import com.management.jobadvertisements1.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.List;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testAddUser() throws Exception {

        // Test verisini oluşturma

        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto();
        userCreateRequestDto.setUserName("John Doe");
        userCreateRequestDto.setEmail("john.doe@example.com");

        // MockMvc ile POST isteği gönderme

        mockMvc.perform(post("/api/v1/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userName\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk());

        // userService'in doğru parametreyle çağrıldığını doğrulama

        Mockito.verify(userService).addUser(any(UserCreateRequestDto.class));
    }

    @Test
    void testUpdateUser() throws Exception {

        UserUpdateRequestDto updateRequestDto = new UserUpdateRequestDto();
        updateRequestDto.setUserName("Updated Name");
        updateRequestDto.setEmail("updated.email@example.com");

        mockMvc.perform(put("/api/v1/users/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userName\":\"Updated Name\", \"email\":\"updated.email@example.com\"}"))
                .andExpect(status().isOk());

        Mockito.verify(userService).updateUser(eq(1L), any(UserUpdateRequestDto.class));
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/v1/users/{id}", 1L))
                .andExpect(status().isOk());

        Mockito.verify(userService).deleteUser(eq(1L));
    }

    @Test
    public void testGetUserById() throws Exception {

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserName("John Doe");
        userResponseDto.setEmail("john.doe@example.com");

        // MockMvc ilə endpoint-ə sorğu göndəririk və cavabları yoxlayırıq
        mockMvc.perform(get("/api/v1/users/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userName\":\"John Doe\", \"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk());

        Mockito.verify(userService).getUserById(eq(1L));
    }
}

