package com.example.library.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usn;
    @Column(name = "student_name")
    private String name;

    @OneToMany(mappedBy = "issueStudent", orphanRemoval = true)
    private List<Issue> issues = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public String getUsn() {
        return usn;
    }

    public String getName() {
        return name;
    }

    public List<Issue> getIssues() {
        return issues;
    }
}
