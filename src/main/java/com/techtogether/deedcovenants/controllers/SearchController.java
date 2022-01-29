package com.techtogether.deedcovenants.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    @Value("${placesApiKey}")
    private String placesApiKey;

    @GetMapping("/search")
    public String renderSearch(Model model) {
        model.addAttribute("placesApiKey", placesApiKey);
        return "search";
    }

    @PostMapping("/search")
    public String processSearchForm(Model model) {
        return "redirect:";
    }
}
