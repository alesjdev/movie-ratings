package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.Review;
import com.alesjdev.movierating.model.Movie;
import com.alesjdev.movierating.service.MovieService;
import com.alesjdev.movierating.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    MovieService movieService;

    @GetMapping("/addReview")
    public String addReview(@RequestParam int movieId, Model theModel){
        // Get previously written review of this movie by current user or a fresh object if no review written
        Review theReview = reviewService.getUserReview(movieId);
        // Get current movie info to display in the page
        Movie theMovie = movieService.findById(movieId);

        theModel.addAttribute("review", theReview);
        theModel.addAttribute("movie", theMovie);
        return "review/write-review";
    }

    @PostMapping("/processReview")
    public String processReview(@ModelAttribute("review") Review theReview){
        reviewService.save(theReview);
        return "redirect:/movie/byId?movieId=" + theReview.getMovieId();
    }
}
