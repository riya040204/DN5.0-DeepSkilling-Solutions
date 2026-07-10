package com.cognizant.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(AccountApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
        LOGGER.info("Account Microservice started on port 8080!");
    }
}
