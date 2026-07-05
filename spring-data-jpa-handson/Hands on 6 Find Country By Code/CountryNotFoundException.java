package com.cognizant.ormlearn.service.exception;

/**
 * Custom exception thrown when a country is not found
 * by the given country code.
 */
public class CountryNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CountryNotFoundException(String message) {
        super(message);
    }

    public CountryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
