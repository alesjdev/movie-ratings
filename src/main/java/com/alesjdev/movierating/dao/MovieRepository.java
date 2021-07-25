package com.alesjdev.movierating.dao;

import com.alesjdev.movierating.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
