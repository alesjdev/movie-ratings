package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.UserRepository;
import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.security.CustomUserDetails;
import com.alesjdev.movierating.validation.PasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public boolean isCorrectPassword(PasswordValidation passwordValidation) {
        // Get currently logged user's password
        String currentEncodedPassword = this.getUserFromPrincipal().getPassword();

        // Get raw password introduced by user
        String rawPassword = passwordValidation.getPassword();

        // Return if provided (encoded) password matches with the original
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, currentEncodedPassword);
    }

    @Override
    public boolean newPasswordsMatch(PasswordValidation passwordValidation) {
        // Return if new passwords match
        return passwordValidation.getNewPassword1().equals(passwordValidation.getNewPassword2());
    }
}
