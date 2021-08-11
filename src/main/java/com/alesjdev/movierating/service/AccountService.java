package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.User;

public interface AccountService {
    public User getUserFromPrincipal();
    public void modifyUser(User theUser);
}
