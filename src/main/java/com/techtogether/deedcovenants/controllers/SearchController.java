package com.techtogether.deedcovenants.controllers;

import com.techtogether.deedcovenants.data.DeedRepository;
import com.techtogether.deedcovenants.models.Deed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Value("${placesApiKey}")
    private String placesApiKey;

    @Autowired
    private DeedRepository deedRepository;

    @GetMapping("/search")
    public String renderSearch(Model model) {
        model.addAttribute("placesApiKey", placesApiKey);
        return "search";
    }

    @PostMapping("/search")
    public String processSearchForm(Model model, @RequestParam(name="searchTerm") String searchTerm) {

        List<Deed> deedsThatMatchSearch = deedRepository.findAllByAddress(searchTerm);
        Boolean hasCovenant = false;
        if(!deedsThatMatchSearch.isEmpty()) {
            hasCovenant = true;
        }

        model.addAttribute("hasCovenant", hasCovenant);
        model.addAttribute("searchAddress", searchTerm);
        return "response";
    }

    @GetMapping("/response")
    public String displayResponse() {
        return "response";
    }
}
