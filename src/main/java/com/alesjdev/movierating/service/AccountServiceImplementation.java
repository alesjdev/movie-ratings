package com.alesjdev.movierating.service;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.security.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {

    @Override
    public User getUserFromPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof UserDetails) {
            user = ((CustomUserDetails)principal).getUser();
        }
        return user;
    }
}
