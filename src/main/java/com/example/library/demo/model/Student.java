package com.example.library.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usn;
    private String name;

    private ArrayList issuedBook = new ArrayList<>();
    @OneToMany(mappedBy = "student")
    private List<Issue> issues;

    public Student(String name) {
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getIssuedBook() {
        return issuedBook;
    }

    public void setIssuedBook(ArrayList issuedBook) {
        this.issuedBook = issuedBook;
    }

    public void addBook(Book book){
        issuedBook.add(book);
    }
}
