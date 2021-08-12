package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.service.AccountService;
import com.alesjdev.movierating.validation.PasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/settings")
    public String manageAccount(Model theModel){
        // Get user from the current security session
        User user = accountService.getUserFromPrincipal();
        // Get the matching object from the database (in case we make modifications, they will display without re-logging)
        user = accountService.findById(user.getId());

        theModel.addAttribute("user", user);
        return "account/account-settings";
    }

    @PostMapping("/changeBio")
    public String changeBio(@ModelAttribute User theUser, Model theModel){
        // Modify user bio
        accountService.modifyBio(theUser);
        // Fetch updated user info from database and send it to view
        theUser = accountService.findById(theUser.getId());

        theModel.addAttribute("user", theUser);
        return "account/account-settings";
    }

    @GetMapping("/changePasswordForm")
    public String showPasswordForm(Model theModel){
        theModel.addAttribute("passwordValidation", new PasswordValidation());
        return "account/change-password";
    }
}
