package com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusinessAndMarketingResponseDto {

    String name;

    String statement;

    String title;
}
