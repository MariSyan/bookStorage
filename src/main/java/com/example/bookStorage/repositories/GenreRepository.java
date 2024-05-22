package com.example.bookStorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookStorage.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {}

