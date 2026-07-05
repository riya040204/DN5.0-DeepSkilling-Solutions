package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // 1. Get all countries
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // 2. Find country by code
    @Transactional
    public Country findByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    // 3. Add new country
    @Transactional
    public void addCountry(String code, String name) {
        Country country = new Country(code, name);
        countryRepository.save(country);
        System.out.println("Country added: " + country);
    }

    // 4. Update country name
    @Transactional
    public void updateCountry(String code, String newName) {
        Country country = countryRepository.findById(code).orElse(null);
        if (country != null) {
            country.setName(newName);
            countryRepository.save(country);
            System.out.println("Country updated: " + country);
        } else {
            System.out.println("Country not found with code: " + code);
        }
    }

    // 5. Delete country
    @Transactional
    public void deleteCountry(String code) {
        if (countryRepository.existsById(code)) {
            countryRepository.deleteById(code);
            System.out.println("Country deleted with code: " + code);
        } else {
            System.out.println("Country not found with code: " + code);
        }
    }

    // 6. Find by partial name
    @Transactional
    public List<Country> findByPartialName(String keyword) {
        return countryRepository.findByNameContaining(keyword);
    }
}
