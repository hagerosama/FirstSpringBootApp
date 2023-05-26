package com.vodafone.springWebDemo.service;

import com.vodafone.springWebDemo.Repository.AuthorRepository;
import com.vodafone.springWebDemo.errorhandlling.NotFoundException;
import com.vodafone.springWebDemo.model.Article;
import com.vodafone.springWebDemo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("RepoAuthorServiceImpl")
public class RepoAuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public Author getAuthorById(Integer id) {
        Optional <Author> authorOptional = authorRepository.findById(id);
        if(authorOptional.isEmpty()) throw new NotFoundException("Author Not found");
        return authorOptional.get();
    }
}
