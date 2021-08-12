package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.service.AccountService;
import com.alesjdev.movierating.validation.PasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


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
    public String changeBio(@Valid @ModelAttribute User theUser, BindingResult bindingResult, Model theModel){

        // Check if Bio is not exceeding maximum size length
        if (bindingResult.hasFieldErrors("aboutMe")){
            return "account/account-settings";
        }

        // Modify user bio
        accountService.modifyBio(theUser);

        // Fetch updated user info from database
        theUser = accountService.findById(theUser.getId());

        theModel.addAttribute("user", theUser);
        return "account/account-settings";
    }

    @GetMapping("/changePasswordForm")
    public String showPasswordForm(Model theModel){
        theModel.addAttribute("passwordValidation", new PasswordValidation());
        return "account/change-password";
    }

    @PostMapping("/changePassword")
    public String changePassword(Model theModel, @Valid @ModelAttribute PasswordValidation passwordValidation,
                                 BindingResult bindingResult){
        // Validate that fields aren't null or empty
        if (bindingResult.hasErrors()){
            return "account/change-password";
        }

        // Validate current password and new one matching with the confirmation
        String errors = accountService.verifyPassword(passwordValidation);
        if (errors != null){
            theModel.addAttribute("registrationError", errors);
            return "account/change-password";
        }

        /* If everything is correct */
        // Update user's password in the database
        accountService.updatePassword(passwordValidation.getNewPassword1());

        // Logout user
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/";
    }
}
