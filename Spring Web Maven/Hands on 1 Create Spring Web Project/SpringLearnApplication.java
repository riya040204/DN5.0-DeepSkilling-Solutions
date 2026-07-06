package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application class
 *
 * @SpringBootApplication combines:
 *   - @Configuration     : marks class as config source
 *   - @EnableAutoConfiguration : auto-configures Spring Boot
 *   - @ComponentScan    : scans for Spring components
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnApplication.class, args);

        // Verify main() is called
        LOGGER.info("Inside main - SpringLearnApplication started successfully!");
        LOGGER.debug("Application is running on Spring Boot");
    }
}
