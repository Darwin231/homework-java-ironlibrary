package com.example.library.demo.repository;

import com.example.library.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author save(Author author);
    Optional<Author> findByAuthorId(int authorId);
    Optional<Author> findByName(String name);
}
