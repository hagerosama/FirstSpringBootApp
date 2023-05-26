package com.vodafone.springWebDemo.service;

import com.vodafone.springWebDemo.model.Article;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();


    Article getArticleById(@Param("id")Integer id);


    List<Article> getArticlesByAuthorName(@Param("authorName") String authorName);


    Article addArticle(Article article);

    void deleteArticle(Integer id);


    Article updateArticle(Integer id, Article article);
}
