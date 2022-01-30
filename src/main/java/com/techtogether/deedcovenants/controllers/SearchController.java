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

    /*NOTES:
     Search PostMapping without @RequestParam annotation will submit the form and response will render.
     Response with @RequestParam does not render the yes/no message.
     Navigating to /response does render the yes/no message.

     Search PostMapping with @RequestParam annotation returns whitelabel error because of addressSearchTerm.
     There was an unexpected error (type=Bad Request, status=400).
Required request parameter 'addressSearchTerm' for method parameter type String is not present
org.springframework.web.bind.MissingServletRequestParameterException: Required request parameter 'addressSearchTerm' for method parameter type String is not present
     */

    @PostMapping("/search")
    public String processSearchForm(Model model, @RequestParam String addressSearchTerm) {
        List<Deed> deedsThatMatchSearch = deedRepository.findByAddress(addressSearchTerm);
        Boolean hasCovenant = false;
        if (deedsThatMatchSearch.contains(addressSearchTerm)) {
            hasCovenant = true;
        }
        model.addAttribute("hasCovenant", hasCovenant);
        model.addAttribute("searchAddress", addressSearchTerm);
        return "response";
    }


//    Has GetMapping option to verify that page still renders and provides option to move out into a "info" page in the nav bar
    @GetMapping("/response")
    public String displayResponse() {
        return "response";
    }
}
