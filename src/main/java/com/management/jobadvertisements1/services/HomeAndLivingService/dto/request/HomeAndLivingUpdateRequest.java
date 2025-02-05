package com.management.jobadvertisements1.services.HomeAndLivingService.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeAndLivingUpdateRequest {
    Long id;

    String name;

    String statement;

    String title;
}
