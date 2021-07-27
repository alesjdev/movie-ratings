package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.Movie;
import com.alesjdev.movierating.entity.Results;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {

    @Value("${tmdb.prefix-path}")
    private String PREFIX_PATH;

    @Value("${tmdb.api-key}")
    private String API_KEY;

    @Override
    public List<Movie> findPopular() {
        return obtainList("movie/popular");
    }

    @Override
    public List<Movie> findTopRated() {
        return obtainList("movie/top_rated");
    }

    @Override
    public List<Movie> findUpcoming() {
        return obtainList("movie/upcoming");
    }

    @Override
    public Movie findById(int movieId) {
        return obtainSingleResult("movie/" + String.valueOf(movieId));
    }

    private List<Movie> obtainList(String from){
        ObjectMapper mapper = new ObjectMapper();
        Results results = null;
        try {
            results = mapper.readValue(new URL(PREFIX_PATH + from + "?" + API_KEY), Results.class );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (results != null) {
            return results.getMovies();
        } else {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
    }

    private Movie obtainSingleResult(String from){
        ObjectMapper mapper = new ObjectMapper();
        Movie theMovie = null;
        try {
            theMovie = mapper.readValue(new URL(PREFIX_PATH + from + "?" + API_KEY), Movie.class );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (theMovie != null) {
            return theMovie;
        } else {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
    }
}
