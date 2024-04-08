package com.example.library.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column(name = "author_name")
    private String name;
    @Column(name = "author_mail")
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList = new ArrayList<>();

    public Author() {
    }

    public Author(String name, String email) {
        setName(name);
        setEmail(email);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorId, author.authorId) && Objects.equals(name, author.name) && Objects.equals(email, author.email) && Objects.equals(bookList, author.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, name, email, bookList);
    }
}
