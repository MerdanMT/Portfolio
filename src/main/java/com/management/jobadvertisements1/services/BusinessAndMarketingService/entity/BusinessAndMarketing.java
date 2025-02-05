package com.management.jobadvertisements1.services.BusinessAndMarketingService.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "business_and_marketing")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusinessAndMarketing {

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
