package com.example.library.demo.repository;

import com.example.library.demo.model.Author;
import com.example.library.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {


    @Query("SELECT b FROM Book b WHERE b.Book.Author= :Author")
    List<Book> findAllByAuthor(@Param("Author") String author);

    List<Object[]> findAllBookAndAuthor();

    @Query("SELECT b FROM Book b WHERE b.Book.Student= :Student")
    List<Book> findAllByUsn(@Param("Student") String student);


    List<Book> findAllByTitle(String title);
    List<Book> findAllByCategory(String category);

}
