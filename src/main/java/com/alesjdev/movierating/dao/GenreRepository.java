package com.alesjdev.movierating.dao;

import com.alesjdev.movierating.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
