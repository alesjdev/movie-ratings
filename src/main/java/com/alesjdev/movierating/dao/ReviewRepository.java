package com.alesjdev.movierating.dao;

import com.alesjdev.movierating.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
