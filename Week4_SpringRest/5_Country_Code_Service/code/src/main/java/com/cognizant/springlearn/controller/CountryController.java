package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
    private final CountryService countryService = new CountryService();
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        logger.info("START");
        Country country = countryService.getCountry(code);
        logger.info("END");
        return country;
    }
} 