package com.example.library.demo;

import com.example.library.demo.model.Author;
import com.example.library.demo.model.Book;
import com.example.library.demo.model.Issue;
import com.example.library.demo.model.Student;
import com.example.library.demo.service.LibraryService;
import com.fasterxml.jackson.core.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    @Autowired
    private final LibraryService libraryService;

    public Menu(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void executeCommand() {
        int choice;
        try {
            do {
                System.out.println("IronLibrary Menu:");
                System.out.println("1. Add a book");
                System.out.println("2. Search book by title");
                System.out.println("3. Search book by category");
                System.out.println("4. Search book by Author");
                System.out.println("5. List all books along with author");
                System.out.println("6. Issue book to student");
                System.out.println("7. List books by usn");
                System.out.println("8. Exit");
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();
                scanner.nextLine();


                switch (choice) {
                    case 1:

                        try {
                            // Ask for book info
                            System.out.println("Enter ISBN: ");
                            String bookIsbn = scanner.nextLine();

                            // If book already exists, increment +1 in its quantity property
                            Optional<Book> bookOptional = libraryService.findBookByIsbn(bookIsbn);
                            if (bookOptional.isPresent()) {
                                bookOptional.get().setQuantity(bookOptional.get().getQuantity() + 1);
                                libraryService.addBook(bookOptional.get());
                                System.out.println("Book with indicated ISBN already known. Successfully added to IronLibrary!");
                                break;
                            }

                            System.out.println("Enter title: ");
                            String bookTitle = scanner.nextLine();
                            System.out.println("Enter category: ");
                            String bookCategory = scanner.nextLine();
                            System.out.println("Enter Author name: ");
                            String authorName = scanner.nextLine();

                            // Create author object and save it in repository (only if it does not already exist)
                            Author bookAuthor;
                            Optional<Author> authorOptional = libraryService.findAuthorByName(authorName);
                            if (!authorOptional.isPresent()) {
                                System.out.println("Enter Author email: ");
                                String authorEmail = scanner.nextLine();
                                bookAuthor = new Author(authorName, authorEmail);
                                libraryService.addAuthor(bookAuthor);
                            } else {
                                System.out.println("Author information already in the system!");
                                bookAuthor = authorOptional.get();
                            }

                            System.out.println("Enter number of books: ");
                            int bookQuantity = scanner.nextInt();


                            // Add book to the repository
                            Book newBook = new Book(bookIsbn, bookTitle, bookCategory, bookQuantity, bookAuthor);
                            libraryService.addBook(newBook);

                            System.out.println("New book successfully added to IronLibrary!");

                        } catch (Exception e) {
                            System.out.println("ISBN needs to be a String");
                            System.out.println(e.getMessage());
                        }

                        break;
                    case 2:
                        System.out.println("Enter the title of the book to search: ");
                        String bookTitleSearch = scanner.nextLine();
                        Optional<List<Book>> optionalBookList = libraryService.findAllBooksByTitle(bookTitleSearch);
                        if (!optionalBookList.get().isEmpty()) {
                            List<Book> bookList = optionalBookList.get();
                            System.out.println("Book(s) found! Displaying info: ");
                            System.out.println("ISBN             Title            Category            Num of books         Author name              Author email");
                            for (Book book : bookList) {
                                book.printBookInfo();
                            }
                        } else {
                            System.out.println("Book with title " + bookTitleSearch + " not found.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter the category of books to search: ");
                        String bookCategorySearch = scanner.nextLine();
                        Optional<List<Book>> optionalBookList2 = libraryService.findAllBooksByCategory(bookCategorySearch);
                        if (optionalBookList2.isPresent()) {
                            List<Book> bookList = optionalBookList2.get();
                            System.out.println("Book(s) found! Displaying info: ");
                            System.out.println("ISBN             Title            Category            Num of books         Author name              Author email");
                            for (Book book : bookList) {
                                book.printBookInfo();
                            }
                        } else {
                            System.out.println("No books found for category " + bookCategorySearch);
                        }
                        break;
                    case 4:
                        System.out.println("Enter author name to display their books: ");
                        String authorNameSearch = scanner.nextLine();
                        Optional<Author> authorOptional1 = libraryService.findAuthorByName(authorNameSearch);
                        if (authorOptional1.isPresent()) {
                            List<Book> bookList1 = libraryService.findBooksByAuthor(authorOptional1.get());
                            System.out.println(authorNameSearch + "'s books found! Displaying info: ");
                            System.out.println("ISBN             Title            Category            Num of books         Author name              Author email");
                            for (Book book : bookList1) {
                                book.printBookInfo();
                            }
                        } else {
                            System.out.println("Author with name " + authorNameSearch + "not found.");
                        }

                        break;
                    case 5:
                        List<Book> allBooks = libraryService.listAllBooks();
                        if (allBooks.isEmpty()) {
                            System.out.println("No books found.");
                        } else {
                            System.out.println("Books list: ");
                            System.out.println("ISBN             Title            Category            Num of books         Author name              Author email");

                            for (Book book : allBooks) {
                                book.printBookInfo();
                            }
                        }

                        break;
                    case 6:
                        // Call issueBookToStudent method
                        // Ask for student usn and check if already exists
                        System.out.println("Enter student usn: ");
                        String studentUsn = scanner.nextLine();

                        Student student;
                        Optional<Student> studentOptional = libraryService.findStudentByUsn(studentUsn);
                        if (!studentOptional.isPresent()) {
                            System.out.println("Enter student name: ");
                            String studentName = scanner.nextLine();
                            student = new Student(studentName);
                            libraryService.addStudent(student);
                            System.out.println("New student added to the system!");
                        } else {
                            System.out.println("Student already in the system!");
                            student = studentOptional.get();
                        }

                        // Ask for book to issue
                        System.out.println("Enter book ISBN to issue: ");
                        String bookIsbnIssue = scanner.nextLine();
                        Optional<Book> optionalBook = libraryService.findBookByIsbn(bookIsbnIssue);
                        if (optionalBook.isPresent()) {
                            Book bookIssue = optionalBook.get();
                            if (bookIssue.getQuantity() > 0) {
                                LocalDateTime todayDate = LocalDateTime.now();
                                LocalDateTime returnDate = todayDate.plusDays(7);
                                Issue issue = new Issue(todayDate, returnDate, student, bookIssue);
                                student.addIssue(issue);
                                bookIssue.setQuantity(bookIssue.getQuantity() - 1);
                                libraryService.addBook(bookIssue);
                                System.out.println("Book " + bookIssue.getTitle() + " issued to " + student.getName() + ". Return date: " + returnDate);
                            } else {
                                System.out.println("Sorry. The book with ISBN " + bookIsbnIssue + " (titled " + bookIssue.getTitle() + ") is not currently available.");
                            }
                        } else {
                            System.out.println("Book with ISBN " + bookIsbnIssue + " not found.");
                        }
                        break;
                    case 7:
                        // Call listBooksByUsn method
                        break;
                    case 8:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice > 0 & choice != 8 & scanner.next().matches("[1-8]")); // Continue until user chooses to exit
        } catch (Exception e) {
            System.out.println("Illegal Argument");
            choice = 1;
        }

    }
}
