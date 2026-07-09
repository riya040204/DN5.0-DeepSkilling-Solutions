package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Protected REST endpoint
 * Requires valid JWT token in Authorization header
 */
@RestController
@CrossOrigin
public class CountryController {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(CountryController.class);

    // GET /countries - requires JWT token
    @GetMapping("/countries")
    public List<Map<String, String>> getCountries() {
        LOGGER.debug("CountryController.getCountries() called");

        List<Map<String, String>> countries = new ArrayList<>();

        Map<String, String> c1 = new HashMap<>();
        c1.put("code", "IN"); c1.put("name", "India");
        countries.add(c1);

        Map<String, String> c2 = new HashMap<>();
        c2.put("code", "US"); c2.put("name", "United States");
        countries.add(c2);

        Map<String, String> c3 = new HashMap<>();
        c3.put("code", "DE"); c3.put("name", "Germany");
        countries.add(c3);

        Map<String, String> c4 = new HashMap<>();
        c4.put("code", "JP"); c4.put("name", "Japan");
        countries.add(c4);

        return countries;
    }
}
