package com.example.library.demo;

import com.example.library.demo.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	private Book book;

	@BeforeEach
	public void setUp() {
		book = new Book();
	}
	@Test
	public void testAddBook() {
		String input = "978-3-16-148410-0\n" +
				"The Notebook\n" +
				"Romance\n" +
				"Nicholas Sparks\n" +
				"nicholassparks@gmail.com\n" +
				"4\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		InputStream originalIn = System.in;
		System.setIn(in);
		DemoApplication.addBook(book);
		System.setIn(originalIn);
		assertEquals("978-3-16-148410-0", book.getIsbn());
		assertEquals("The Notebook", book.getTitle());
		assertEquals("Romance", book.getCategory());
		assertEquals(4, book.getQuantity());
	}

}
