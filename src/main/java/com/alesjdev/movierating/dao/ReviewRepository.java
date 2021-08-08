package com.alesjdev.movierating.dao;

import com.alesjdev.movierating.entity.Review;
import com.alesjdev.movierating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // Find a specific review created by an user, if any, for that user to edit it
    public Review findByUserAndMovieId(User user, int movieId);

    // Find all reviews of a movie, sorted by date posted from newest to oldest
    public Set<Review> findByMovieIdOrderByDatePostedDesc(int movieId);

    // Find the latest reviews added for any movie, limited to 20 latest additions
    public Set<Review> findTop20ByOrderByDatePostedDesc();
}
