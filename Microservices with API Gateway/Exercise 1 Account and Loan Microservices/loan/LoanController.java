package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Loan Microservice Controller
 * Runs on port 8081
 */
@RestController
@CrossOrigin
public class LoanController {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(LoanController.class);

    // GET /loans/{number}
    // Returns dummy loan details
    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        LOGGER.debug("LoanController: getLoan() called for number: {}",
                     number);

        // Dummy response - no backend connectivity
        Loan loan = new Loan(
            number,
            "car",
            400000.00,
            3258.00,
            18
        );

        LOGGER.debug("Returning loan: {}", loan);
        return loan;
    }
}
