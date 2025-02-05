package com.management.jobadvertisements1.article.repository;

import com.management.jobadvertisements1.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> getArticleByFkUserId(long fkUserId);

}
