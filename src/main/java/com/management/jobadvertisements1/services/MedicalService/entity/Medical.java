package com.management.jobadvertisements1.services.MedicalService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "medical")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Medical {

    @Id
    @GeneratedValue
    Long id;

    @Column
    Long fkUserId;

    @Column
    String name;

    @Column
    String explanation;

    @Column
    String title;
}
