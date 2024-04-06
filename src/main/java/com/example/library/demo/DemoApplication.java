package com.example.library.demo;

import com.example.library.demo.model.Author;
import com.example.library.demo.model.Book;
import com.example.library.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
	private static Scanner scanner = new Scanner(System.in);
	@Autowired
	BookRepository bookRepository;
	public static void executeCommand(BookRepository bookRepository) {
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
					Book newBook = new Book(bookIsbn,bookTitle,bookCategory,bookQuantity,bookAuthor);
					bookRepository.save(newBook);

					System.out.println("Book successfully added to IronLibrary.");

					break;
				case 2:
					System.out.println("Enter the title of the book to search: ");
					String bookTitleSearch = scanner.nextLine();
					Optional<List<Book>> optionalBookList = bookRepository.findAllByTitle(bookTitleSearch);
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
					// Call searchBookByCategory method
					break;
				case 4:
					// Call searchBookByAuthor method
					break;
				case 5:
					// Call listAllBooks method
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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		executeCommand();
	}

}
