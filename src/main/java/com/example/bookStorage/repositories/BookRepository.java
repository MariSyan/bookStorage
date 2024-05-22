package com.example.bookStorage.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookStorage.entities.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
    
    Page<Book> findByTitleContaining(String title, Pageable pageable);
    Page<Book> findByAuthorNameContaining(String author, Pageable pageable);
    Page<Book> findByGenreContaining(String genre, Pageable pageable);
}

