package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.Actor;
import com.alesjdev.movierating.entity.Genre;
import com.alesjdev.movierating.entity.Movie;
import com.alesjdev.movierating.service.MovieService;
import com.alesjdev.movierating.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    ActorService actorService;

    @GetMapping("/movies")
    public String getAllMovies(Model theModel){
        List<Movie> movieList = movieService.findAll();
        theModel.addAttribute("movies", movieList);
        return "movie-list";
    }

    @GetMapping("/addMovie")
    public void addMovie(){
        Movie newMovie = new Movie("Star Wars II", "war in the stars", "trailer link", "pic link", 1934);
        Genre genre = new Genre ("SCIFI");
        Actor actor = new Actor("Mark Hamill", "hamill.jpg", "Plays Luke Skywalker");
        newMovie.addGenre(genre);
        newMovie.addCast(actor);
        movieService.save(newMovie);
    }

}
