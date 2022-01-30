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
    public String processSearchForm(Model model, String addressSearchTerm) {
        model.addAttribute("searchAddress", addressSearchTerm);
//        do something with Iterable and Optional???
//        use as reference?  https://www.codejava.net/frameworks/spring-boot/connect-to-mysql-database-examples
//        query database directly  https://stackoverflow.com/questions/5809239/query-a-mysql-db-using-java
        return "response";
    }

    @GetMapping("/response")
    public String displayResponse(@RequestParam(required = false) String addressSearchTerm, Model model) {
        List<Deed> deedsThatMatchSearch = deedRepository.findByAddress(addressSearchTerm);
        Boolean hasCovenant = false;
        if (deedsThatMatchSearch.contains(addressSearchTerm)) {
            hasCovenant = true;
        }
        model.addAttribute("hasCovenant", hasCovenant);
        model.addAttribute("searchAddress", addressSearchTerm);
        return "response";
    }
}


/*
if (categoryId == null) {
            model.addAttribute("deeds", deedRepository.findAll());
        } else {
            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
            if (result.isEmpty()) {  //user asked for a category id and that id wasn't in the database
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            } else {
                EventCategory category = result.get();
                model.addAttribute("title", "Events in category: " + category.getName());
                model.addAttribute("events", category.getEvents());
            }
        }
 */