package com.example.library.demo;
import com.example.library.demo.model.Book;
import com.example.library.demo.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
	private static Scanner scanner = new Scanner(System.in);

	private static HashMap<String, Book> bookList = new HashMap<>();


	public static void addBook(Book book) {


		System.out.println("Enter isbn : ");
		String isbn = scanner.nextLine();
		System.out.println("Enter title : ");
		String title = scanner.nextLine();
		System.out.println("Enter category : ");
		String category = scanner.nextLine();
		System.out.println("Enter Author name : ");
		String authorName = scanner.nextLine();
		System.out.println("Enter Author mail : ");
		String authorMail = scanner.nextLine();
		System.out.println("Enter number of books : ");
		int quantity = scanner.nextInt();
		scanner.nextLine();

		book.setIsbn(isbn);
		book.setTitle(title);
		book.setCategory(category);
		book.setQuantity(quantity);
		System.out.println("Book added successfully!");

		bookList.put(authorName, book);
	}

	public static void listBooksByUSN(String usn) {
		// Retrieve the student object using the provided USN
		Student student = getStudentByUSN(usn); // Implement this method to get the student object by USN

		// Check if the student exists
		if (student != null) {
			// Retrieve the list of books issued to the student
			List<Book> issuedBooks = student.getIssuedBooks();
			// Check if the student has any issued books
			if (!issuedBooks.isEmpty()) {
				// Print the table header
				System.out.println("Book Title\tStudent Name\tReturn Date");
				// Iterate over each issued book and print its details
				for (Book book : issuedBooks) {
					String returnDate = getReturnDateForBook(book); // Implement this method to get the return date for an issued book
					System.out.printf("%s\t%s\t%s%n", book.getTitle(), student.getName(), returnDate);
				}
			} else {
				System.out.println("This student hasn't issued any books.");
			}
		} else {
			System.out.println("No student found with the provided USN.");
		}
	}

	public static void executeCommand() {

		int choice = 0;
		do {
			System.out.println("Menu:");
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
				addBook(new Book()); // Call addBook method
				break;
			case 2:
				// Call searchBookByTitle method
				break;
			case 3:
				// Call searchBookByCategory method
				break;
			case 4:
				System.out.println("Which author do you want to read? (Type the id): \n");
				bookList.forEach((key,value) -> {
					System.out.println(key);
				});
				try{
					String authorName = scanner.next();
					if(bookList.containsKey(authorName)){
						System.out.println(bookList.containsKey(authorName));
					}else{
						System.err.println("The author introduced does not exist");
					}
				}catch(IllegalArgumentException iae){
					System.err.println("The option introduced is not correct");
				}
				break;

			case 5:
				System.out.println("All books and authors: \n");
				bookList.forEach((key,value) -> {
					System.out.println(key + ": " +  value.getTitle());
				});
				break;

			case 6:
				// Call issueBookToStudent method
				break;
			case 7:
				// Call listBooksByUsn method
				System.out.println("Enter USN:");
				String usn = scanner.nextLine();
				listBooksByUSN(usn);
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
