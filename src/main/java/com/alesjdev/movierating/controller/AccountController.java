package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.service.AccountService;
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
        User user = accountService.getUserFromPrincipal();
        theModel.addAttribute("user", user);
        return "account/account-settings";
    }

    @PostMapping("/changeBio")
    public String changeBio(@ModelAttribute User theUser, Model theModel){
        accountService.modifyUser(theUser);
        return "account/account-settings";
    }
}
