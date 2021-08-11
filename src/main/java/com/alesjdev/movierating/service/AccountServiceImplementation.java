package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.UserRepository;
import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserFromPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof UserDetails) {
            user = ((CustomUserDetails)principal).getUser();
        }
        return user;
    }

    @Override
    public void modifyUser(User theUser){
        userRepository.save(theUser);
    }
}
