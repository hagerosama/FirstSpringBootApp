package com.vodafone.springWebDemo.contoller;

import com.vodafone.springWebDemo.model.Author;
import com.vodafone.springWebDemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = "com.vodafone.Repository")

public class AuthorController {

    @Autowired
    @Qualifier("RepoAuthorServiceImpl")
    private AuthorService authorService;


    @GetMapping(value = "/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
}
