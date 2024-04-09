package com.example.library.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
    @JoinColumn(name = "student_usn", referencedColumnName = "student_usn")
    private Student issueStudent;
    @OneToOne
    @JoinColumn(name = "book_isbn", referencedColumnName = "book_isbn")
    private Book issueBook;



    public Issue(LocalDateTime todayDate, LocalDateTime returnDate, Student student, Book bookIssue) {
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

    public void printIssueInfo() {
        System.out.printf("%-20s %-20s %-15s\n", issueBook.getTitle(), issueStudent.getName(), returnDate);
    }
}
