package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context =
            SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);
        LOGGER.info("Inside main");

        // Test 1: Find valid country
        testFindCountryByCode("IN");

        // Test 2: Find another valid country
        testFindCountryByCode("US");

        // Test 3: Find invalid country - should throw exception
        testFindCountryByCode("XX");
    }

    private static void testFindCountryByCode(String code) {
        LOGGER.info("Start - finding country with code: {}", code);
        try {
            Country country = countryService.findCountryByCode(code);
            LOGGER.debug("Country: {}", country);

            // Validate country name is not null
            if (country.getName() != null && !country.getName().isEmpty()) {
                LOGGER.debug("Country name is valid: {}", country.getName());
            }

        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End - findCountryByCode for code: {}", code);
    }
}
