package com.example.library.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private String isbn;
    private String title;
    private String category;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "author_name")
    private Author author;

    @OneToOne(mappedBy = "issueBook")
    private Issue issue;


    //Parametrized constructor
    public Book(String isbn, String title, String category, Integer quantity) {
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

