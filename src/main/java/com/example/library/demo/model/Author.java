package com.example.library.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private String name;
    private String email;
    @OneToMany
    @JoinColumn(name = "book_isbn")
    private ArrayList<Book> authorBook = new ArrayList<>();

    public Author() {
    }

    public Author(String name, String email) {
        setName(name);
        setEmail(email);;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
