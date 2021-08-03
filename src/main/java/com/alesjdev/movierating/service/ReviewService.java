package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.Review;

public interface ReviewService {

    public Review getUserReview(int movieId);
    public void save(Review theReview);
}
