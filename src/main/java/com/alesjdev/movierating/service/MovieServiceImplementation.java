package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.MovieRepository;
import com.alesjdev.movierating.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void save(Movie theMovie) {
        movieRepository.save(theMovie);
    }
}
