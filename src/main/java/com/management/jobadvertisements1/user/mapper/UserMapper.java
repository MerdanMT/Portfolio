package com.management.jobadvertisements1.user.mapper;

import com.management.jobadvertisements1.security.MyUserDetails;
import com.management.jobadvertisements1.user.dto.request.UserCreateRequestDto;
import com.management.jobadvertisements1.user.dto.request.UserUpdateRequestDto;
import com.management.jobadvertisements1.user.dto.response.UserResponseDto;
import com.management.jobadvertisements1.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toUserResponseDto(User user);

    User toUser(UserCreateRequestDto userRequestDto);

    User toUser(@MappingTarget User user, UserUpdateRequestDto userUpdateRequestDto);

    MyUserDetails toMyUserDetails(User user);

}
