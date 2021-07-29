package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/castDetail")
    public String getCastDetail(@RequestParam int castId, Model theModel){
        theModel.addAttribute("person", personService.findById(castId));
        return "person-detail";
    }
}
