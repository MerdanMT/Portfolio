package com.management.jobadvertisements1.article.controller;

import com.management.jobadvertisements1.article.dto.request.ArticleCreateRequestDto;
import com.management.jobadvertisements1.article.dto.request.ArticleUpdateRequestDto;
import com.management.jobadvertisements1.article.dto.response.ArticleResponseDto;
import com.management.jobadvertisements1.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public void addArticle(@RequestBody ArticleCreateRequestDto articleCreateRequestDto){
        articleService.addArticle(articleCreateRequestDto);
    }

    @GetMapping("/{id}")
   public ArticleResponseDto findArticleById(@PathVariable Long id){
        return articleService.getArticleById(id);
   }

   @GetMapping("/get-all")
    public List<ArticleResponseDto> findAllArticles(){
        return articleService.getAllArticles();
    }

    @PutMapping
    public void updateArticle(@RequestBody ArticleUpdateRequestDto articleUpdateRequestDto){
        articleService.updateArticle(articleUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
    }

    @GetMapping("/get-article-by-user/{fkUserId}")
    public List<ArticleResponseDto> getArticleByUserId(@PathVariable Long fkUserId){
        return articleService.getArticleByUserId(fkUserId);
    }
}
