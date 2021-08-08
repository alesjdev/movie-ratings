package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.Review;

import java.util.Set;

public interface ReviewService {

    public Review getUserReview(int movieId);
    public void save(Review theReview);
    public Set<Review> findReviewsByMovieId(int movieId);
    public void delete(Review theReview);
    public Set<Review> getLatest();
}
