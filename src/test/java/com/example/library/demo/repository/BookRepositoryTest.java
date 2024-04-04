package com.example.library.demo.repository;

import com.example.library.demo.model.Book;
import com.example.library.demo.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    private final String exampleBookIsbn = "978-3-16-148410-0";

    @BeforeEach
    void setUp() {
        Book exampleBook = new Book(exampleBookIsbn,"The Notebook","Romance",4);
        bookRepository.save(exampleBook);
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    void addedBookExistsInRepo() {
        Optional<Book> bookOptional = bookRepository.findById(exampleBookIsbn);
        assertTrue(bookOptional.isPresent());
    }
    @Test
    void findAllByTitle() {
        List<Book> bookOptional = bookRepository.findAllByTitle("The Notebook");
        assertEquals(1,bookOptional.size());
    }

    @Test
    void findAllByCategory() {
        List<Book> bookOptional = bookRepository.findAllByCategory("Romance");
        assertEquals(1,bookOptional.size());
    }
}