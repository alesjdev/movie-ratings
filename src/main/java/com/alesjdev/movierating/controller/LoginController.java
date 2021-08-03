package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/loginPage")
    public String showMyLoginPage() {
        return "login/login-form";
    }

    @GetMapping("/register/show")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "login/signup-form";
    }

    @PostMapping("/register/process")
    public String processRegister(User user) {
        userService.save(user);
        return "login/register-success";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "error/access-denied";
    }
}
