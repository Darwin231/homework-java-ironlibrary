package com.example.library.demo.repository;

import com.example.library.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<List<Book>> findAllByTitle(String title);
    Optional<List<Book>> findAllByCategory(String category);
}
