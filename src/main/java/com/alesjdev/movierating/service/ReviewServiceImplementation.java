package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.ReviewRepository;
import com.alesjdev.movierating.entity.Review;
import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.model.Movie;
import com.alesjdev.movierating.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReviewServiceImplementation implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieService movieService;

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
        removePasswordsFromUsers(movieReviews);
        // Return reviews
        return movieReviews;
    }

    @Override
    public void delete(Review theReview) {
        reviewRepository.delete(theReview);
    }

    @Override
    public Set<Review> getLatest() {
        // Find the latest user reviews for any movie
        Set<Review> userReviews = reviewRepository.findTop20ByOrderByDatePostedDesc();
        // Remove passwords from users
        removePasswordsFromUsers(userReviews);
        // Add full movie object to each review
        addMovieToReviews(userReviews);
        // Return reviews
        return userReviews;
    }

    private void removePasswordsFromUsers(Set<Review> movieReviews){
        movieReviews.forEach(review -> review.getUser().setPassword(null));
    }

    private void addMovieToReviews(Set<Review> reviews){
        reviews.forEach(review -> review.setMovie(movieService.findById(review.getMovieId())));
    }
}
