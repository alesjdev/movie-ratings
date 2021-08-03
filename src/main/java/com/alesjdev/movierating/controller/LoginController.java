package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.dao.UserRepository;
import com.alesjdev.movierating.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/loginPage")
    public String showMyLoginPage() {
        return "login/login-form";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "login/signup-form";
    }

    @PostMapping("/processRegistration")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "login/register-success";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "error/access-denied";
    }
}
