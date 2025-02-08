package com.management.jobadvertisements1.user.controller;

import com.management.jobadvertisements1.user.dto.request.UserCreateRequestDto;
import com.management.jobadvertisements1.user.dto.request.UserUpdateRequestDto;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.entity.User;
import com.management.jobadvertisements1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    @PostMapping("/register")
    public void addUser(@RequestBody UserCreateRequestDto userCreateRequestDto){
        userService.addUser(userCreateRequestDto);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto updateRequestDto){
        userService.updateUser(id, updateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/get-all-users")
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get-my-workplace/{id}")
    public String getAllMyWorkplaces(@PathVariable Long id){
        return userService.getAllMyWorkplaces(id);
    }

    @PutMapping("/activate/{id}/{string}")
    public void getUserByActivateOnOff(@PathVariable Long id,@PathVariable String string){
        userService.getUserByActivateOnOff(id,string);
    }

    @GetMapping("/get-all-active-users")
    List<UserResponseDto> getAllUsersActivate() {
        return userService.getAllUsersActivate();
    }

    @GetMapping("/get-all-users-by-region/{region}")
    List<UserResponseDto> getAllUsersByRegion(@PathVariable String region){
        return userService.getAllUsersByRegion(region);
    }

    @GetMapping("/get-user-by-email/{email}")
    User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
}
