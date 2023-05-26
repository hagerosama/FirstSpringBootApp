package com.vodafone.springWebDemo.service;

import com.vodafone.springWebDemo.model.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    List<Author> authors = new ArrayList<>();
    Integer id = 0;

    public AuthorServiceImpl() {
        Author author = new Author();
        author.setId(1);
        author.setName("ahmed");
        authors.add(author);
    }

    @Override
    public Author getAuthorById(Integer id) {
        for (Author author : authors) {
            if (id.equals(author.getId())) {
                return author;
            }
        }
        return null;
    }
}
