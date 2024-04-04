package com.example.library.demo.service;

import com.example.library.demo.model.Book;
import com.example.library.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }
    public List<Book> findAllByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    public List<Book> findAllByCategory(String category) {
        return bookRepository.findAllByCategory(category);
    }
}
