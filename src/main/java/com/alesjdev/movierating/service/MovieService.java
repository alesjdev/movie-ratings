package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> findPopular();
}
