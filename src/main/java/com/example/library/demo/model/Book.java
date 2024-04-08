package com.example.library.demo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private String isbn;
    private String title;
    private String category;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    //Parametrized constructor
    public Book(String isbn, String title, String category, Integer quantity, Author author) {
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
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }

        // Remove any hyphens or spaces from the ISBN
        isbn = isbn.replaceAll("[\\s-]+", "");

        //Check whether ISBN-10 or ISBN-13
        if (!isbn.matches("\\d{10}") && !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("Invalid ISBN format");
        }

        this.isbn = isbn;
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
        this.quantity = quantity;
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

