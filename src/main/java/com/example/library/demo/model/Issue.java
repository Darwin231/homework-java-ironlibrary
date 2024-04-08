package com.example.library.demo.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "student_usn", referencedColumnName = "usn")
    private Student issueStudent;
    @OneToOne
    @JoinColumn(name = "book_isbn", referencedColumnName = "isbn")
    private Book issueBook;



    public Issue() {
    }

    public Issue(LocalDateTime issueDate, LocalDateTime returnDate, Student issueStudent, Book issueBook) {
        setIssueDate(issueDate);
        setReturnDate(returnDate);
        setIssueStudent(issueStudent);
        setIssueBook(issueBook);
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(issueId, issue.issueId) && Objects.equals(issueDate, issue.issueDate) && Objects.equals(returnDate, issue.returnDate) && Objects.equals(issueStudent, issue.issueStudent) && Objects.equals(issueBook, issue.issueBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, issueDate, returnDate, issueStudent, issueBook);
    }

    public void printIssueInfo() {
        System.out.printf("%-20s %-20s %-15s\n", issueBook.getTitle(), issueStudent.getName(), returnDate);
    }
}
