package com.example.library.demo.service;

import com.example.library.demo.model.*;
import com.example.library.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    StudentRepository studentRepository;

    // Book Repository
    public void addBook (Book book) {
        Optional<Book> bookOptional = bookRepository.findByIsbn(book.getIsbn());
        if (bookOptional.isPresent()) {
            bookOptional.get().setQuantity(book.getQuantity()+1);
            bookRepository.save(book);
        }
        bookRepository.save(book);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<List<Book>> findAllByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    public Optional<List<Book>> findAllByCategory(String category) {
        return bookRepository.findAllByCategory(category);
    }

    // Author Repository
    public Optional<Author> findByAuthorId(int authorId) {
        return authorRepository.findByAuthorId(authorId);
    }

    public Optional<List<Author>> findAllByAuthorName(String name) {
        return authorRepository.findAllByName(name);
    }

    // Student Repository
    public Optional<Student> findByUsn(String usn) {
        return studentRepository.findByUsn(usn);
    }

    public Optional<List<Student>> findAllByStudentName(String name) {
        return studentRepository.findAllByName(name);
    }

}
