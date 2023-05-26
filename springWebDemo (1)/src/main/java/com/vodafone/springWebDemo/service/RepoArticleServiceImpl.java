package com.vodafone.springWebDemo.service;


import com.vodafone.springWebDemo.Repository.ArticleRepository;
import com.vodafone.springWebDemo.contoller.ArticlesController;
import com.vodafone.springWebDemo.contoller.AuthorController;
import com.vodafone.springWebDemo.errorhandlling.NotFoundException;
import com.vodafone.springWebDemo.model.Article;
import com.vodafone.springWebDemo.model.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service("RepoArticleServiceImpl")
@Transactional
public class RepoArticleServiceImpl implements ArticleService{

    @Autowired
    @Lazy
    ArticleRepository articleRepository;



    @Override
    public List<Article> getAllArticles() {
        List<Article> article1 = new ArrayList<>();
        List<Article> allArticle = articleRepository.findAll();
        for (Article article : allArticle) {
            article1.add(addLinks(article));
        }

        return article1;
    }

    @Override
    public Article getArticleById(Integer id) {
        Optional <Article> articleOptional = articleRepository.findById(id);
        if(articleOptional.isEmpty()) throw new NotFoundException("Not found");
        return articleOptional.get();
    }

    @Override
    public List<Article> getArticlesByAuthorName(String authorName) {
        return articleRepository.findByName(authorName);
    }

    @Override
    public Article addArticle(Article article) {
        addLinks(article);
        articleRepository.save(article);
        return null;
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article updateArticle(Integer id, Article article) {
        Optional<Article> article1 = articleRepository.findById(id);
        if (article1.isEmpty()){
            throw new NotFoundException(String.format("The Article with id '%s' was not found", id));
        }
        addLinks(article1.get());
        article.setId(id);
        return articleRepository.save(article);
    }

    private Article addLinks(Article article){
        List<Links> links = new ArrayList<>();
        Links self = new Links();

        Link selfLink = linkTo(methodOn(ArticlesController.class)
                .getArticle(article.getId())).withRel("self");

        self.setRel("self");
        self.setHref(selfLink.getHref());

        Links authorLink = new Links();
        Link authLink = linkTo(methodOn(AuthorController.class)
                .getAuthorById(article.getAuthorId())).withRel("author");
        authorLink.setRel("author");
        authorLink.setHref(authLink.getHref());

        links.add(self);
        links.add(authorLink);
        article.setLinks(links);
        return article;
    }
}
