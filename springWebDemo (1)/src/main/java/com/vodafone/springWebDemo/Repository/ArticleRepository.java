package com.vodafone.springWebDemo.Repository;

import com.vodafone.springWebDemo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findByName(String authorName);

}

