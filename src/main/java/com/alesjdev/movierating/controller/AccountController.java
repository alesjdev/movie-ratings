package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accountSettings")
    public String manageAccount(Model theModel){
        User user = accountService.getUserFromPrincipal();
        theModel.addAttribute("user", user);
        return "account/account-settings";
    }
}
