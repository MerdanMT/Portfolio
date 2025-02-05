package com.management.jobadvertisements1.user.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {

    String fullName;

    String userName;

    String email;

    String birthDate;

    String phoneNumber;

    String address;

    String aboutMe;

    String university;

    String photo;

    String myWorkplaces;

    String isActive;

    String hobbies;

    String region;

}
