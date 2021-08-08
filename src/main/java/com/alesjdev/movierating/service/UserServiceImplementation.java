package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.RoleRepository;
import com.alesjdev.movierating.dao.UserRepository;
import com.alesjdev.movierating.entity.Role;
import com.alesjdev.movierating.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MovieService movieService;


    // Save new user, assign enabled, set USER role
    public void save(User newUser){
        // Encode password and replace the plain one
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);

        // Set new User to enabled by default
        newUser.setEnabled(true);

        // Add USER role by default
        Set<Role> roles = new HashSet<>();
        Optional<Role> optionalRole = roleRepository.findById(1);
        if(optionalRole.isPresent()){
            Role userRole = optionalRole.get();
            roles.add(userRole);
            newUser.setAuthorities(roles);
        }

        // Save new User in DB
        userRepository.save(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(int id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()){
            user = optional.get();
            // Take password out to prevent security issues
            user.setPassword(null);
            // Add movie detail to the reviews
            user.getReviewList().forEach(review -> review.setMovie(movieService.findById(review.getMovieId())));
            // Sort reviews in descending order by date posted
            user.setReviewList(user.getReviewList().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)));
        }
        return user;
    }
}
