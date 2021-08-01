package com.alesjdev.movierating.controller;

import com.alesjdev.movierating.service.MovieService;
import com.alesjdev.movierating.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    MovieService movieService;

    @Autowired
    PersonService personService;


    @GetMapping("/byKeyword")
    public String searchFor(@RequestParam String keyword, Model theModel) {
        theModel.addAttribute("movies", movieService.findByKeyword(keyword));
        theModel.addAttribute("people", personService.findByKeyword(keyword));
        theModel.addAttribute("keyword", keyword);
        return "search/search-results";
    }
}
