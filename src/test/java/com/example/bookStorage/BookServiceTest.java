package com.example.bookStorage;


import com.example.bookStorage.entities.Author;
import com.example.bookStorage.entities.Book;
import com.example.bookStorage.repositories.BookRepository;
import com.example.bookStorage.services.BookService;
import com.example.bookStorage.repositories.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;
    private Author author;

    @BeforeEach
    public void setUp() {
        author = new Author();
        author.setId(1L);
        author.setName("F. Scott Fitzgerald");

        book = new Book();
        book.setId(1L);
        book.setTitle("The Great Gatsby");
        book.setAuthor(author);
        book.setGenre("Fiction");
        book.setPrice(10.99);
    }

    @Test
    public void testSaveBook() {
        // Given
        when(authorRepository.save(any(Author.class))).thenReturn(author);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // When
        Book savedBook = bookService.saveBook(book);

        // Then
        assertNotNull(savedBook);
        assertEquals("The Great Gatsby", savedBook.getTitle());
        assertEquals("F. Scott Fitzgerald", savedBook.getAuthor().getName());
        assertEquals("Fiction", savedBook.getGenre());
        assertEquals(10.99, savedBook.getPrice());

        verify(authorRepository, times(1)).save(any(Author.class));
        verify(bookRepository, times(1)).save(any(Book.class));
    }
}
