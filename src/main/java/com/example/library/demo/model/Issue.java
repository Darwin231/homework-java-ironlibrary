package com.example.library.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;
    private String issueDate;
    private String returnDate;

    @OneToOne
    @JoinColumn(name = "student_usn")
    private Student issueStudent;
    @OneToOne
    @JoinColumn(name = "book_isbn")
    private Book issueBook;


    public Issue() {
    }

    public Issue(String issueDate, String returnDate, Student student, Book book) {
        setIssueDate(issueDate);
        setReturnDate(returnDate);
        setIssueStudent(student);
        setIssueBook(book);
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

    public void setIssueStudent(Student student) {
        this.issueStudent = student;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }
}
