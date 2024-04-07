package com.example.library.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(mappedBy = "book")
    private Issue issue;

    //Parametrized constructor
    public Book(String isbn, String title, String category, Integer quantity) {
        setIsbn(isbn);
        setTitle(title);
        setCategory(category);
        setQuantity(quantity);
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
}

