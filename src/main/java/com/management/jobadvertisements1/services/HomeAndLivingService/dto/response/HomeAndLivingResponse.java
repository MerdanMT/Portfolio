package com.management.jobadvertisements1.services.HomeAndLivingService.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeAndLivingResponse {

    String name;

    String statement;

    String title;
}
