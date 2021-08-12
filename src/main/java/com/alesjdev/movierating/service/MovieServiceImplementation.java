package com.alesjdev.movierating.service;

import com.alesjdev.movierating.model.Movie;
import com.alesjdev.movierating.model.MovieSearch;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Service
public class MovieServiceImplementation implements MovieService {

    // Variable to set how many results to show (20 results per page queried)
    private int PAGES_TO_QUERY = 5;

    @Value("${tmdb.prefix-path}")
    private String PREFIX_PATH;

    @Value("${tmdb.api-key}")
    private String API_KEY;

    @Override
    public Set<Movie> findPopular() {
        return obtainMovieList("/movie/popular", PAGES_TO_QUERY);
    }

    @Override
    public Set<Movie> findTopRated() {
        return obtainMovieList("/movie/top_rated", PAGES_TO_QUERY);
    }

    @Override
    public Set<Movie> findUpcoming() {
        return obtainMovieList("/movie/upcoming", PAGES_TO_QUERY);
    }

    @Override
    public Movie findById(int movieId) {
        return obtainSingleMovie("/movie/" + movieId);
    }

    @Override
    public Set<Movie> findByGenre(int genreId) {
        return obtainMovieList("/discover/movie", PAGES_TO_QUERY, genreId);
    }

    @Override
    public Set<Movie> findByKeyword(String keyword) {
        return obtainMovieListByKeyword("/search/movie", keyword);
    }


    private Set<Movie> obtainMovieList(String from, int pages){
        // Create set to hold results from all pages queried
        Set<Movie> results = new HashSet<>();

        // Create JSON's object mapper
        ObjectMapper mapper = new ObjectMapper();

        // Create new object to hold search results
        MovieSearch movieSearch = null;
        try {
            // Add 20 results to the search for every page queried
            for (int page = 1; page <= pages; page++) {
                movieSearch = mapper.readValue(new URL(PREFIX_PATH
                                + from
                                + "?" + API_KEY
                                + "&" + "page=" + page),
                        MovieSearch.class);
                results.addAll(movieSearch.getMovies());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Throw runtime exception if there was a problem fetching the data
        if (results.isEmpty()) {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
        return results;
    }

    private Set<Movie> obtainMovieList(String from, int pages, int genreId){
        // Create set to hold results from all pages queried
        Set<Movie> results = new HashSet<>();

        // Create JSON's object mapper
        ObjectMapper mapper = new ObjectMapper();

        // Create new object to hold search results
        MovieSearch movieSearch = null;
        try {
            // Add 20 results to the search for every page queried
            for (int page = 1; page <= pages; page++) {
                movieSearch = mapper.readValue(new URL(PREFIX_PATH
                                + from
                                + "?" + API_KEY
                                + "&" + "with_genres=" + genreId
                                + "&" + "include_adult=" + false
                                + "&" + "sort_by=" + "popularity.desc"
                                + "&" + "page=" + page),
                        MovieSearch.class);
                results.addAll(movieSearch.getMovies());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Throw runtime exception if there was a problem fetching the data
        if (results.isEmpty()) {
            throw new RuntimeException("There was a problem fetching the data from the API.");
        }
        return results;
    }

    private Set<Movie> obtainMovieListByKeyword(String from, String keyword){
        ObjectMapper mapper = new ObjectMapper();
        MovieSearch movieSearch = null;
        try {
            movieSearch = mapper.readValue(new URL(PREFIX_PATH + from
                            + "?" + API_KEY
                            + "&" + "query=" + keyword
                            + "&" + "include_adult=" + false),
                    MovieSearch.class );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (movieSearch != null) {
            return movieSearch.getMovies();
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
