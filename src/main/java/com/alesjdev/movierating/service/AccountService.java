package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.User;

public interface AccountService {
    public User getUserFromPrincipal();
    public void modifyBio(User theUser);
    public User findById(int userId);
}
