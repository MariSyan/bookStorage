package com.example.bookStorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookStorage.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {}

