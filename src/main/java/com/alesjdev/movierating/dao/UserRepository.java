package com.alesjdev.movierating.dao;

import com.alesjdev.movierating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
