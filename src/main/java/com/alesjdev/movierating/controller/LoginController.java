package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/loginPage")
    public String displayLogin(Model model) {
        model.addAttribute("user", new User());
        return "login/login-form";
    }

    @GetMapping("/register/show")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "login/signup-form";
    }

    // Process data received in form, and save user if the fields are valid
    @PostMapping("/register/process")
    public String processRegister( Model theModel,
                @Valid @ModelAttribute("user") User user, BindingResult bindingResult ) {

        // Check if user introduced data has any errors
        if (bindingResult.hasErrors()){
            return "login/signup-form";
        }

        // Check if username or email already exists in database
        User existingByEmail = userService.findByEmail(user.getEmail());
        if (existingByEmail != null){
            theModel.addAttribute("registrationError", "There is an account already registered with this email");
            return "login/signup-form";
        }
        User existingByName = userService.findByUsername(user.getUsername());
        if (existingByName != null){
            theModel.addAttribute("registrationError", "Sorry, that username is already taken");
            return "login/signup-form";
        }

        // If everything is ok, save new user in the database
        userService.save(user);
        return "login/register-success";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "error/access-denied";
    }
}
