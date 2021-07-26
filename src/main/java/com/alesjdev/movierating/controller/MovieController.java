package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.Movie;
import com.alesjdev.movierating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService theMovieService;

    @GetMapping("/popular")
    public String mainPage(Model theModel){
        theModel.addAttribute("popular", theMovieService.findPopular());
        return "popular";
    }

}
