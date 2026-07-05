package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

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

        testGetAllCountries();
        testFindByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testFindByPartialName();
    }

    // 1. Get all countries
    private static void testGetAllCountries() {
        LOGGER.info("Start - testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries={}", countries.size());
        countries.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End - testGetAllCountries");
    }

    // 2. Find by code
    private static void testFindByCode() {
        LOGGER.info("Start - testFindByCode");
        Country country = countryService.findByCode("IN");
        LOGGER.debug("Found country={}", country);
        LOGGER.info("End - testFindByCode");
    }

    // 3. Add new country
    private static void testAddCountry() {
        LOGGER.info("Start - testAddCountry");
        countryService.addCountry("XX", "Test Country");
        Country added = countryService.findByCode("XX");
        LOGGER.debug("Added country={}", added);
        LOGGER.info("End - testAddCountry");
    }

    // 4. Update country
    private static void testUpdateCountry() {
        LOGGER.info("Start - testUpdateCountry");
        countryService.updateCountry("XX", "Updated Test Country");
        Country updated = countryService.findByCode("XX");
        LOGGER.debug("Updated country={}", updated);
        LOGGER.info("End - testUpdateCountry");
    }

    // 5. Delete country
    private static void testDeleteCountry() {
        LOGGER.info("Start - testDeleteCountry");
        countryService.deleteCountry("XX");
        Country deleted = countryService.findByCode("XX");
        LOGGER.debug("After delete, country={}", deleted);
        LOGGER.info("End - testDeleteCountry");
    }

    // 6. Find by partial name
    private static void testFindByPartialName() {
        LOGGER.info("Start - testFindByPartialName");
        List<Country> countries = countryService.findByPartialName("United");
        LOGGER.debug("Countries matching 'United'={}", countries);
        LOGGER.info("End - testFindByPartialName");
    }
}
