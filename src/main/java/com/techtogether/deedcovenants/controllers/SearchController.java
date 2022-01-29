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
    public String processSearchForm(Model model, @RequestParam String searchTerm) {
        Boolean hasCovenant;
        Iterable<Deed> listDeeds = deedRepository.findAll();
//        do something with Iterable and Optional???
//        use as reference?  https://www.codejava.net/frameworks/spring-boot/connect-to-mysql-database-examples
        if (listDeeds.equals(searchTerm)) {
            hasCovenant = true;
        }
//        model.addAttribute("listDeeds", listDeeds);

        return "response";
    }

//    @GetMapping("/response")
//    public String renderResponse(Model model) {
//        return "response";
//    }
}
