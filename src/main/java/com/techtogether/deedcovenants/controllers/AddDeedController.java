package com.techtogether.deedcovenants.controllers;

import com.techtogether.deedcovenants.data.DeedRepository;
import com.techtogether.deedcovenants.models.Deed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AddDeedController {

    @Autowired
    DeedRepository deedRepository;

    @Value("${placesApiKey}")
    private String placesApiKey;

    @GetMapping("/add")
    public String renderAddDeedPage(Model model) {
        model.addAttribute(new Deed());
        model.addAttribute("placesApiKey", placesApiKey);
        model.addAttribute("title", "Add Deed");
        return "add";
    }

    @PostMapping("/add")
    public String processAddDeedForm(@ModelAttribute Deed deed, Model model) {
        deedRepository.save(deed);
        return "redirect:";
    }
}
