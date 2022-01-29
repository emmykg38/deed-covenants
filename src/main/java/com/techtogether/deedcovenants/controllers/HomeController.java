package com.techtogether.deedcovenants.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping()
    public String renderIndex() {
        return "index";
    }

}
