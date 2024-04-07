package com.example.library.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "return_date")
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "student_name")
    private Student student;
    @OneToOne
    @JoinColumn(name = "isbn")
    private Book book;

    public Issue() {
    }

    public Issue(String issueDate, String returnDate) {
        setIssueDate(issueDate);
        setReturnDate(returnDate);
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Student getIssueStudent() {
        return student;
    }

    public void setIssueStudent(Student student) {
        this.student = student;
    }

    public Book getIssueBook() {
        return book;
    }

    public void setIssueBook(Book issueBook) {
        this.book = book;
    }
}
