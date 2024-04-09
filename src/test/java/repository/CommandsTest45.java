package repository;

import com.example.library.demo.model.Author;
import com.example.library.demo.model.Book;
import com.example.library.demo.model.Issue;
import com.example.library.demo.model.Student;
import com.example.library.demo.repository.AuthorRepository;
import com.example.library.demo.repository.BookRepository;
import com.example.library.demo.repository.IssueRepository;
import com.example.library.demo.repository.StudentRepository;
import com.example.library.demo.service.LibraryService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommandsTest45 {
    private LibraryService libraryService;
    private Book book;
    private Issue issue;
    private Student student;
    private Author author;

    @Mock
    AuthorRepository authorRepository;
    @Mock
    BookRepository bookRepository;
    @Mock
    IssueRepository issueRepository;
    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        author = new Author("Darwin", "darwin@email.com");
        book = new Book("978-7-7529-4912-2", "title_test", "Horror", 1, author);
        issue = new Issue("12/12/2023", "14/12/2023");
        student = new Student("Laura");
        libraryService = new LibraryService(authorRepository, bookRepository, issueRepository, studentRepository);
    }

    @AfterEach
    public void cleanUp(){
        libraryService.clean();
    }

    @Test
    public void command1(){

        libraryService.addBook(book);
        libraryService.addAuthor(author);
        libraryService.addStudent(student);
        libraryService.addIssue(issue);

        List<Book> books = libraryService.findAllBooks();

        System.out.println(books);

        assertEquals(1, books.size());
    }

    @Test
    public void command2(){
        Optional<List<Book>> test = libraryService.findAllBooksByTitle("title_test");
        assertEquals(test.stream().count(), 1);

    }
    /*@Test
    void findAllByTitle() {
        Optional<List<Book>> bookOptional = bookRepository.findAllByTitle("The Notebook");
        assertEquals(1,bookOptional.get().size());
    }

    @Test
    void findAllByCategory() {
        Optional<List<Book>> bookOptional = bookRepository.findAllByCategory("Romance");
        assertEquals(1,bookOptional.get().size());
    }*/



}
