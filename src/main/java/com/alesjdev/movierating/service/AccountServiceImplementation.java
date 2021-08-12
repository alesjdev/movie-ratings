package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.UserRepository;
import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public void modifyBio(User modifiedUser){
        // User object only has id and a parameter to modify, so we fetch the full user from the database
        Optional<User> optional = userRepository.findById(modifiedUser.getId());
        User user = null;
        if (optional.isPresent()){
            user = optional.get();
            // Overwrite the user's bio with the one received
            user.setAboutMe(modifiedUser.getAboutMe());
            // Save modified changes in the database
            userRepository.save(user);
        }
    }

    @Override
    public User findById(int userId) {
        User user = null;
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()){
            user = optional.get();
        }
        return user;
    }
}
