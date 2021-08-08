package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.User;

public interface UserService {
    public void save(User newUser);
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User findById(int id);
}
