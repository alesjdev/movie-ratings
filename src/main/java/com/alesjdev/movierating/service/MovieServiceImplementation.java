package com.alesjdev.movierating.service;

import com.alesjdev.movierating.model.Movie;
import com.alesjdev.movierating.model.Person;
import com.alesjdev.movierating.model.Results;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImplementation implements MovieService {

    @Value("${tmdb.prefix-path}")
    private String PREFIX_PATH;

    @Value("${tmdb.api-key}")
    private String API_KEY;

    @Override
    public Set<Movie> findPopular() {
        return obtainMovieList("/movie/popular");
    }

    @Override
    public Set<Movie> findTopRated() {
        return obtainMovieList("/movie/top_rated");
    }

    @Override
    public Set<Movie> findUpcoming() {
        return obtainMovieList("/movie/upcoming");
    }

    @Override
    public Movie findById(int movieId) {
        return obtainSingleMovie("/movie/" + String.valueOf(movieId));
    }

    @Override
    public Set<Movie> findByGenre(int genreId) {
        return obtainMovieListByGenre("/discover/movie", genreId);
    }


    private Set<Movie> obtainMovieList(String from){
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

    private Set<Movie> obtainMovieListByGenre(String from, int genreId){
        ObjectMapper mapper = new ObjectMapper();
        Results results = null;
        try {
            results = mapper.readValue(new URL(PREFIX_PATH + from
                    + "?" + API_KEY
                    + "&" + "with_genres=" + genreId
                    + "&" + "include_adult=" + false
                    + "&" + "sort_by=" + "popularity.desc"),
                        Results.class );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (results != null) {
            return results.getMovies();
        } else {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
    }

    private Movie obtainSingleMovie(String from){
        ObjectMapper mapper = new ObjectMapper();
        Movie theMovie = null;
        try {
            theMovie = mapper.readValue(new URL(PREFIX_PATH + from + "?" + API_KEY), Movie.class );
            Movie movieCast = mapper.readValue(new URL(PREFIX_PATH + "/movie/" + theMovie.getId() + "/credits?" + API_KEY), Movie.class );
            theMovie.setCast(movieCast.getCast());
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
