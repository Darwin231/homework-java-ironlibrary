package com.example.library.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer issueId;
    private String issueDate;
    private String returnDate;
    @ManyToOne
    @JoinColumn(name = "issue_student")
    private Student issueStudent;
    @OneToOne
    @JoinColumn(name = "book_isbn")
    private Book issueBook;

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
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }
}
