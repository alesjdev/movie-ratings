package com.alesjdev.movierating.service;

import com.alesjdev.movierating.model.Movie;

import java.util.List;
import java.util.Set;

public interface MovieService {
    public Set<Movie> findPopular();
    public Set<Movie> findTopRated();
    public Set<Movie> findUpcoming();
    public Movie findById(int movieId);
    public Set<Movie> findByGenre(int genreId);
    public Set<Movie> findByKeyword(String keyword);
}
