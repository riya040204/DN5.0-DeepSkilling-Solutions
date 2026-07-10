package com.cognizant.greetservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(GreetController.class);

    @GetMapping("/greet")
    public String greet() {
        LOGGER.debug("GreetController.greet() called");
        return "Hello World from Greet Service!";
    }
}
