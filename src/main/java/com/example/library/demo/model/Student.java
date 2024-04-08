package com.example.library.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private String usn;
    @Column(name = "student_name")
    private String name;

    @OneToMany(mappedBy = "issueStudent", orphanRemoval = true)
    private List<Issue> issues = new ArrayList<>();

    public Student() {
    }

    public Student(String usn, String name) {
        setUsn(usn);
        setName(name);
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

    public void addIssue(Issue newIssue) {
        this.issues.add(newIssue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(usn, student.usn) && Objects.equals(name, student.name) && Objects.equals(issues, student.issues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usn, name, issues);
    }
}
