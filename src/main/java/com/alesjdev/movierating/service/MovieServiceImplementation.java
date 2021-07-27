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
        ObjectMapper mapper = new ObjectMapper();
        Results results = null;
        try {
            results = mapper.readValue(new URL(PREFIX_PATH + "movie/popular?" + API_KEY), Results.class );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results.getMovies();
    }
}
