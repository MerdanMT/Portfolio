package com.management.jobadvertisements1.services.BusinessAndMarketingService.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusinessAndMarketingUpdateRequestDto {

    Long id;

    String name;

    String statement;

    String title;
}
