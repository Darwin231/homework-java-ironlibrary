package com.example.library.demo.model;

import com.example.library.demo.Utils.Functions;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // email check
        if(Functions.isValidEmail(email)){
            this.email = email;
        } else {
            throw new IllegalArgumentException("Not a valid e-mail");
        }
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
