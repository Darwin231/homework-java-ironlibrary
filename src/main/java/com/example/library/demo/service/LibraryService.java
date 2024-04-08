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

    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository, IssueRepository issueRepository, StudentRepository studentRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.issueRepository = issueRepository;
        this.studentRepository = studentRepository;
    }

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

    public Optional<List<Book>> findAllBooksByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    public Optional<List<Book>> findAllBooksByCategory(String category) {
        return bookRepository.findAllByCategory(category);
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    // Author Repository
    public void addAuthor (Author author) {
        authorRepository.save(author);
    }

    public Optional<Author> findAuthorByAuthorId(int authorId) {
        return authorRepository.findByAuthorId(authorId);
    }

    public Optional<Author> findAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    // Student Repository
    public Optional<Student> findStudentByUsn(String usn) {
        return studentRepository.findByUsn(usn);
    }

    public Optional<Student> findStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public void addStudent (Student student) {
        studentRepository.save(student);
    }

    public List<Book> findBooksByAuthor(Author author){
        return bookRepository.findAllByAuthor(author.getAuthorId());
    }

    // Issue Repository
    public void addIssue (Issue issue) {
        issueRepository.save(issue);
    }
    /*public List<Book> findByUsn(Student student){
        return bookRepository.findAllByUsn(student.getUsn());
    }*/

}
