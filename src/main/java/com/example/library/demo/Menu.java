package com.example.library.demo;

import com.example.library.demo.model.Author;
import com.example.library.demo.model.Book;
import com.example.library.demo.service.LibraryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private final LibraryService libraryService;

    public Menu(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void executeCommand() {
        int choice = 0;
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
                    // Ask for book info
                    System.out.println("Enter ISBN: ");
                    String bookIsbn = scanner.nextLine();

                    // CHECK IF BOOK ALREADY EXISTS IN THE REPOSITORY --> create method findbyisbn in bookrepo

                    System.out.println("Enter title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Enter category: ");
                    String bookCategory = scanner.nextLine();
                    System.out.println("Enter number of books: ");
                    int bookQuantity = scanner.nextInt();
                    System.out.println("Enter Author name: ");
                    String authorName = scanner.nextLine();
                    System.out.println("Enter Author email: ");
                    String authorEmail = scanner.nextLine();
                    Author bookAuthor = new Author(authorName,authorEmail);

                    // Add book to the repository
                    Book newBook = new Book(bookIsbn,bookTitle,bookCategory,bookQuantity);
                    libraryService.addBook(newBook);

                    System.out.println("Book successfully added to IronLibrary.");

                    break;
                case 2:
                    System.out.println("Enter the title of the book to search: ");
                    String bookTitleSearch = scanner.nextLine();
                    Optional<List<Book>> optionalBookList = libraryService.findAllBooksByTitle(bookTitleSearch);
                    if (optionalBookList.isPresent()) {
                        List<Book> bookList = optionalBookList.get();
                        for (Book book : bookList) {
                            System.out.println(book.toString()); // REVIEW IF THIS PRINT IS IN THE DESIRED FORMAT
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
                        for (Book book : bookList) {
                            System.out.println(book.toString()); // REVIEW IF THIS PRINT IS IN THE DESIRED FORMAT
                        }
                    } else {
                        System.out.println("No books found for category " + bookCategorySearch);
                    }
                    break;
                case 4:
                    System.out.println("Enter author name to display their books: ");
                    String authorNameSearch = scanner.nextLine();

                    // we should first create the Author object using findbyauthorname and then use
                    // bookRepository.findAllByAuthor(author); passing the object as argument

                    break;
                case 5:
                    System.out.println("Books list: ");
                    List<Book> allBooks = libraryService.listAllBooks();
                    for (Book book : allBooks) {
                        System.out.println(book.toString()); // REVIEW IF THIS PRINT IS IN THE DESIRED FORMAT
                    }
                    break;
                case 6:
                    // Call issueBookToStudent method
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
        } while (choice != 8); // Continue until user chooses to exit
    }
}
