package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.Movie;
import com.alesjdev.movierating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @Autowired
    MovieService theMovieService;

    @GetMapping("/movies")
    public String mainPage(Model theModel){
        theModel.addAttribute("popular", theMovieService.findPopular());
        theModel.addAttribute("latest", theMovieService.findLatest());
        theModel.addAttribute("topRated", theMovieService.findTopRated());
        theModel.addAttribute("upcoming", theMovieService.findUpcoming());
        return "movies";
    }

}
