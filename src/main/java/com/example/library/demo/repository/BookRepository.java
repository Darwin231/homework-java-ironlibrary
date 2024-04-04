package com.example.library.demo.repository;

import com.example.library.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findAllByTitle(String title);
    List<Book> findAllByCategory(String category);
}
