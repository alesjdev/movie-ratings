package com.alesjdev.movierating.dao;

import com.alesjdev.movierating.entity.Review;
import com.alesjdev.movierating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public Review findByUserAndMovieId(User user, int movieId);

    public Set<Review> findByMovieId(int movieId);
}
