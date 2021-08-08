package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.entity.User;
import com.alesjdev.movierating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/byId")
    public String userDetails(@RequestParam int userId, Model theModel){
        User theUser = userService.findById(userId);
        theModel.addAttribute("user", theUser);
        return "user/user-details";
    }
}
