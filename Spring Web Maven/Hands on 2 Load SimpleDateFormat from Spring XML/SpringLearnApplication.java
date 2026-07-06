package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main - Application started!");

        // Call displayDate method
        displayDate();
    }

    private static void displayDate() {
        LOGGER.info("Start - displayDate()");

        // Step 1: Load Spring XML config
        ApplicationContext context =
            new ClassPathXmlApplicationContext("date-format.xml");

        LOGGER.debug("Spring XML context loaded!");

        // Step 2: Get SimpleDateFormat bean from context
        SimpleDateFormat format =
            context.getBean("dateFormat", SimpleDateFormat.class);

        LOGGER.debug("SimpleDateFormat bean retrieved: {}", format.toPattern());

        // Step 3: Parse date string using the format
        try {
            Date date = format.parse("31/12/2018");
            System.out.println("Parsed Date: " + date);
            LOGGER.debug("Parsed date successfully: {}", date);

            // Format current date using same bean
            String today = format.format(new Date());
            System.out.println("Today formatted: " + today);
            LOGGER.debug("Today formatted: {}", today);

            // Parse another date
            Date date2 = format.parse("15/08/1947");
            System.out.println("Independence Day: " + date2);
            LOGGER.debug("Independence Day: {}", date2);

        } catch (ParseException e) {
            LOGGER.error("Error parsing date: {}", e.getMessage());
        }

        LOGGER.info("End - displayDate()");
    }
}
