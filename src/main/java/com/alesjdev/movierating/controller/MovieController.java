package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.Movie;
import com.alesjdev.movierating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    @Autowired
    MovieService theMovieService;

    @GetMapping("/")  // Main page, list popular, top rated and upcoming
    public String mainPage(Model theModel){
        theModel.addAttribute("popularMovies", theMovieService.findPopular());
        theModel.addAttribute("topRatedMovies", theMovieService.findTopRated());
        theModel.addAttribute("upcomingMovies", theMovieService.findUpcoming());
        return "main";
    }

    @GetMapping("/movie/{movieId}")  // Get movie by Id and display all details
    public String movieDetails(@RequestParam int movieId, Model theModel){
        theModel.addAttribute("movie", theMovieService.findById(movieId));
        return "movie-detail";
    }


}
