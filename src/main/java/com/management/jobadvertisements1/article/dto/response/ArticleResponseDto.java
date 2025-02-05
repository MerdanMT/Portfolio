package com.management.jobadvertisements1.article.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleResponseDto {

    String title;

    String description;

    LocalDate publishedDate;

    String imageUrl;

    String category;
}
