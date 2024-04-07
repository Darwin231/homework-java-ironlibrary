package com.example.library.demo.repository;

import com.example.library.demo.model.Author;
import com.example.library.demo.model.Book;
import com.example.library.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByIsbn(String isbn);
    List<Book> findAll();
    Optional<List<Book>> findAllByTitle(String title);
    Optional<List<Book>> findAllByCategory(String category);

//    @Query("SELECT b FROM Book b WHERE b.author.authorId= :authorId")
//    List<Book> findAllByAuthor(@Param("authorId") Integer authorId);



    /*@Query("SELECT b FROM Book b WHERE b.student.usn= :studentUsn")
    List<Book> findAllByUsn(@Param("studentUsn") String studentUsn);*/
}