package com.example.library.demo.model;

import com.example.library.demo.Utils.Functions;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_isbn")
    private String isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    //Parametrized constructor
    public Book(String isbn, String title, String category, Integer quantity, Author author) {;
        setIsbn(isbn);
        setTitle(title);
        setCategory(category);
        setQuantity(quantity);
        setAuthor(author);
    }

    public Book() {
    }

    //Getters & Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn.substring(2) == "978" & (isbn.length() >= 14 | isbn.length() <= 17)) {
            this.isbn = isbn;
        } else {throw new IllegalArgumentException("ISBN cannot be null or empty");}

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        if (Functions.isValidQuantity(quantity)){
        this.quantity = quantity;
        } else {
        throw new IllegalArgumentException("Quantity cannot be negative");}
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(category, book.category) && Objects.equals(quantity, book.quantity) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, category, quantity, author);
    }

    //toString
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public void printBookInfo() {
        System.out.printf("%-20s %-20s %-10s %-20s %-20s\n", isbn, title, category, quantity, author.getName(), author.getEmail());
    }
}

