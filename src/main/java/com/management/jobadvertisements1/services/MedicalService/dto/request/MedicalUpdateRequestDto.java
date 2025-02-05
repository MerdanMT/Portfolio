package com.management.jobadvertisements1.services.MedicalService.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedicalUpdateRequestDto {

    Long id;

    Long fkUserId;

    String name;

    String statement;

    String title;
}
