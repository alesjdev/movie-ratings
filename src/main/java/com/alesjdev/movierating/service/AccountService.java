package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.validation.PasswordValidation;

public interface AccountService {
    public User getUserFromPrincipal();
    public void modifyBio(User theUser);
    public User findById(int userId);
    public String verifyPassword(PasswordValidation passwordValidation);
    public void updatePassword(String rawPassword);
}
