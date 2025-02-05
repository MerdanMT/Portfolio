package com.management.jobadvertisements1.article.service;

import com.management.jobadvertisements1.article.dto.request.ArticleCreateRequestDto;
import com.management.jobadvertisements1.article.dto.request.ArticleUpdateRequestDto;
import com.management.jobadvertisements1.article.dto.response.ArticleResponseDto;

import java.util.List;

public interface ArticleService {

    void addArticle(ArticleCreateRequestDto articleCreateRequestDto);

    ArticleResponseDto getArticleById(Long id);

    List<ArticleResponseDto> getAllArticles();

    void updateArticle(ArticleUpdateRequestDto articleUpdateRequestDto);

    void deleteArticle(Long id);

    List<ArticleResponseDto> getArticleByUserId(Long fkUserId);

}
