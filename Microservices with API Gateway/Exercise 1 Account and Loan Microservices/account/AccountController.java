package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Account Microservice Controller
 * Runs on port 8080
 */
@RestController
@CrossOrigin
public class AccountController {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(AccountController.class);

    // GET /accounts/{number}
    // Returns dummy account details
    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        LOGGER.debug("AccountController: getAccount() called for number: {}",
                     number);

        // Dummy response - no backend connectivity
        Account account = new Account(
            number,
            "savings",
            234343.00
        );

        LOGGER.debug("Returning account: {}", account);
        return account;
    }
}
