package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Find countries where name contains keyword (partial match)
    List<Country> findByNameContaining(String keyword);

    // Find countries starting with a letter
    List<Country> findByNameStartingWith(String letter);
}
