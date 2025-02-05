package com.management.jobadvertisements1.services.MedicalService.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedicalResponseDto {

    String name;

    String statement;

    String title;
}
