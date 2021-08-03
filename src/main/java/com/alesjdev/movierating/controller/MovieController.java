package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.Review;
import com.alesjdev.movierating.model.Movie;
import com.alesjdev.movierating.service.MovieService;
import com.alesjdev.movierating.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller()
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService theMovieService;

    @Autowired
    ReviewService theReviewService;


    @GetMapping("/popular")  // Popular movies
    public String getPopular(Model theModel){
        theModel.addAttribute("keyword", "Popular");
        theModel.addAttribute("movies", theMovieService.findPopular());
        return "movie/movie-results";
    }

    @GetMapping("/top")  // Top rated movies
    public String getTop(Model theModel){
        theModel.addAttribute("keyword", "Top Rated");
        theModel.addAttribute("movies", theMovieService.findTopRated());
        return "movie/movie-results";
    }

    @GetMapping("/upcoming")  // Upcoming movies
    public String getUpcoming(Model theModel){
        theModel.addAttribute("keyword", "Upcoming");
        theModel.addAttribute("movies", theMovieService.findUpcoming());
        return "movie/movie-results";
    }

    @GetMapping("/byGenre")
    public String moviesByGenre(@RequestParam int genreId, @RequestParam String genreName, Model theModel){
        theModel.addAttribute("keyword", genreName);
        theModel.addAttribute("movies", theMovieService.findByGenre(genreId));
        return "movie/movie-results";
    }

    @GetMapping("/byId")  // Get movie by Id and display all details
    public String movieDetails(@RequestParam int movieId, Model theModel){
        // Retrieve movie details from the API
        Movie theMovie = theMovieService.findById(movieId);

        // Find all reviews that belong to that movie and add them to the corresponding field
        Set<Review> movieReviews = theReviewService.findReviewsByMovieId(movieId);
        theMovie.setReviews(movieReviews);

        // Add attribute Movie with reviews already in it
        theModel.addAttribute("movie", theMovie);

        return "movie/movie-detail";
    }




}
