package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.ReviewRepository;
import com.alesjdev.movierating.entity.Review;
import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

@Service
public class ReviewServiceImplementation implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public Review getUserReview(int movieId) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof UserDetails) {
            user = ((CustomUserDetails)principal).getUser();
        }

        Review review = reviewRepository.findByUserAndMovieId(user, movieId);
        if (review == null){
            review = new Review();
            review.setUser(user);
            review.setMovieId(movieId);
        }

        return review;
    }

    @Override
    public void save(Review theReview) {
        // If the review is new, add current date and time, if not keep the old ones
        if (theReview.getDatePosted() == 0L){
            theReview.setDatePosted(System.currentTimeMillis());
        }
        reviewRepository.save(theReview);
    }

    @Override
    public Set<Review> findReviewsByMovieId(int movieId) {
        // Find all reviews that belong to a movie
        Set<Review> movieReviews = reviewRepository.findByMovieIdOrderByDatePostedDesc(movieId);
        // Delete passwords from 'user' fields, to avoid security issues
        movieReviews.forEach(review -> review.getUser().setPassword(null));
        // Return reviews
        return movieReviews;
    }
}
