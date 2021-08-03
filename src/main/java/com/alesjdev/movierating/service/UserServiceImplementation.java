package com.alesjdev.movierating.service;

import com.alesjdev.movierating.dao.RoleRepository;
import com.alesjdev.movierating.dao.UserRepository;
import com.alesjdev.movierating.entity.Role;
import com.alesjdev.movierating.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


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
}
