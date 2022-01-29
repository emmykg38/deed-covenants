package com.techtogether.deedcovenants.controllers;

import com.techtogether.deedcovenants.data.DeedRepository;
import com.techtogether.deedcovenants.models.Deed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddDeedController {

    @Autowired
    DeedRepository deedRepository;


    @GetMapping("/add")
    public String renderAddDeedPage(Model model) {
        model.addAttribute(new Deed());
        return "add";
    }
}
