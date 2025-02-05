package com.management.jobadvertisements1.article.mapper;

import com.management.jobadvertisements1.article.dto.request.ArticleCreateRequestDto;
import com.management.jobadvertisements1.article.dto.request.ArticleUpdateRequestDto;
import com.management.jobadvertisements1.article.dto.response.ArticleResponseDto;
import com.management.jobadvertisements1.article.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

     ArticleResponseDto toArticleResponseDto(Article article);

     Article toArticle(ArticleCreateRequestDto articleCreateRequestDto);

     Article toArticle(@MappingTarget Article article, ArticleUpdateRequestDto articleUpdateRequestDto);
}
