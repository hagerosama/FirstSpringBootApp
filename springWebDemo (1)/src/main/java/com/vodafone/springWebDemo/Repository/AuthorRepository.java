package com.vodafone.springWebDemo.Repository;

import com.vodafone.springWebDemo.model.Article;
import com.vodafone.springWebDemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
