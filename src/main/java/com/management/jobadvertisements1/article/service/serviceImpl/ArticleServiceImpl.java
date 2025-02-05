package com.management.jobadvertisements1.article.service.serviceImpl;

import com.management.jobadvertisements1.article.dto.request.ArticleCreateRequestDto;
import com.management.jobadvertisements1.article.dto.request.ArticleUpdateRequestDto;
import com.management.jobadvertisements1.article.dto.response.ArticleResponseDto;
import com.management.jobadvertisements1.article.entity.Article;
import com.management.jobadvertisements1.article.mapper.ArticleMapper;
import com.management.jobadvertisements1.article.repository.ArticleRepository;
import com.management.jobadvertisements1.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public void addArticle(ArticleCreateRequestDto articleCreateRequestDto) {

        articleRepository.save(articleMapper.toArticle(articleCreateRequestDto));
    }

    @Override
    public ArticleResponseDto getArticleById(Long id) {

        Article article = articleRepository.findById(id).orElse(null);
        return articleMapper.toArticleResponseDto(article);
    }

    @Override
    public List<ArticleResponseDto> getAllArticles() {

        List<Article> articles = articleRepository.findAll();
        List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();
        for (Article article : articles) {
            articleResponseDtos.add(articleMapper.toArticleResponseDto(article));
        }
        return articleResponseDtos;
    }

    @Override
    public void updateArticle(ArticleUpdateRequestDto articleUpdateRequestDto) {

        Article article = articleRepository.findById(articleUpdateRequestDto.getId()).orElse(null);

        articleRepository.save(articleMapper.toArticle(article, articleUpdateRequestDto));
    }

    @Override
    public void deleteArticle(Long id) {

        articleRepository.deleteById(id);
    }

    @Override
    public List<ArticleResponseDto> getArticleByUserId(Long fkUserId) {

        List<Article> articles= articleRepository.getArticleByFkUserId(fkUserId);

        List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();

        for (Article article : articles) {
            articleResponseDtos.add(articleMapper.toArticleResponseDto(article));
        }

        return articleResponseDtos;

    }
}
