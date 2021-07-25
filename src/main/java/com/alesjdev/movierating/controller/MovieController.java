package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.Genre;
import com.alesjdev.movierating.entity.Movie;
import com.alesjdev.movierating.entity.Person;
import com.alesjdev.movierating.service.MovieService;
import com.alesjdev.movierating.service.PersonService;
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
    PersonService personService;

    @GetMapping("/movies")
    public String getAllMovies(Model theModel){
        List<Movie> movieList = movieService.findAll();
        theModel.addAttribute("movies", movieList);
        return "movie-list";
    }

    @GetMapping("/addMovie")
    public void addMovie(){
        Movie newMovie = new Movie("el frosti I", "war in the seas", "taaa link", "picc link", 1934);
        Genre genre = new Genre ("SALTOS");
        Person person = new Person("osico", "foto nise", "er makinon");
        newMovie.addGenre(genre);
        newMovie.addCast(person);
        movieService.save(newMovie);
    }

}
