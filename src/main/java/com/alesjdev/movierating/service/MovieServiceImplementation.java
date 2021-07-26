package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {

    @Value("${prefix_path}")
    private String PREFIX_PATH;

    @Value("${api_key}")
    private String API_KEY;

    @Override
    public List<Movie> findPopular() {
        ObjectMapper mapper = new ObjectMapper();
        List<Movie> popularMovies = null;
        try {
            popularMovies = mapper.readValue(new URL(PREFIX_PATH + "movie/popular?" + API_KEY), new TypeReference<List<Movie>>(){} );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return popularMovies;
    }
}
