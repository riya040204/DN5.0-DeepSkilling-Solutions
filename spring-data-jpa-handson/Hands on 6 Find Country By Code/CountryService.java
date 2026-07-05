package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Get all countries
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    /**
     * Find country by country code
     * Throws CountryNotFoundException if not found
     *
     * @Transactional - Spring creates Hibernate session
     * and manages transaction automatically
     */
    @Transactional
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        // Step 1: Try to find country by ID (code)
        Optional<Country> result = countryRepository.findById(countryCode);

        // Step 2: Check if country was found
        if (!result.isPresent()) {
            throw new CountryNotFoundException(
                "Country not found for code: " + countryCode);
        }

        // Step 3: Return the found country
        Country country = result.get();
        return country;
    }
}
