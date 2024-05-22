package com.example.bookStorage.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bookStorage.entities.Author;
import com.example.bookStorage.entities.Book;
import com.example.bookStorage.repositories.AuthorRepository;
import com.example.bookStorage.repositories.BookRepository;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;


    public Book saveBook(Book book) {
        // Save the author if it's new (not persisted yet)
        if (book.getAuthor().getId() == null) {
            Author savedAuthor = authorRepository.save(book.getAuthor());
            book.setAuthor(savedAuthor);
        }
        return bookRepository.save(book);
    }
    
   

    public Book updateBook(Long id, Book bookDetails) {
        // Retrieve the existing book
        Optional<Book> optionalBook = bookRepository.findById(id);
        
        if (!optionalBook.isPresent()) {
            throw new RuntimeException("Book not found with id " + id);
        }
        
        Book book = optionalBook.get();

        // Update book details
        book.setTitle(bookDetails.getTitle());
        book.setGenre(bookDetails.getGenre());
        book.setPrice(bookDetails.getPrice());

        // Update or save author details
        if (bookDetails.getAuthor() != null && bookDetails.getAuthor().getId() != null) {
            Optional<Author> optionalAuthor = authorRepository.findById(bookDetails.getAuthor().getId());
            if (!optionalAuthor.isPresent()) {
                throw new RuntimeException("Author not found with id " + bookDetails.getAuthor().getId());
            }
            book.setAuthor(optionalAuthor.get());
        } else if (bookDetails.getAuthor() != null) {
            Author savedAuthor = authorRepository.save(bookDetails.getAuthor());
            book.setAuthor(savedAuthor);
        }

        return bookRepository.save(book);
    }
	

    public Page<Book> searchBooks(String title, String author, String genre, Pageable pageable) {
        if (title != null) {
            return bookRepository.findByTitleContaining(title, pageable);
        } else if (author != null) {
            return bookRepository.findByAuthorNameContaining(author, pageable);
        } else if (genre != null) {
            return bookRepository.findByGenreContaining(genre, pageable);
        } else {
            return bookRepository.findAll(pageable);
        }
    }
    
    
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }
}
