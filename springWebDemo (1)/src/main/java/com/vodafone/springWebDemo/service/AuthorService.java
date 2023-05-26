package com.vodafone.springWebDemo.service;

import com.vodafone.springWebDemo.model.Author;

import java.util.Optional;

public interface AuthorService {
    Author getAuthorById(Integer id);
}
