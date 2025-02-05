package com.management.jobadvertisements1.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
    Long id;

    @NotNull
    @Column
    String fullName;

    @NotNull
    @Column(unique = true)
    String userName;

    @NotNull
    @Column(unique = true)
    String email;

    @NotNull
    @Column
    String password;

    @NotNull
    @Column
    String birthDate;

    @NotNull
    @Column
    String phoneNumber;

    @Column
    String address;

    @Column
    Boolean isActive;

    @Column
    String aboutMe;

    @Column
    String university;

    @Column
    String photo;

    @Column
    String myWorkplaces;

    @Column
    String myWorkplacesExplanation;

    @Column
    String hobbies;

    @Column
    String region;

}
