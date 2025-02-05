package com.management.jobadvertisements1.services.ITService.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ITResponseDto {

    String name;

    String statement;

    String title;
}
