package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private String code;
    private String name;
    private static final Logger logger = LoggerFactory.getLogger(Country.class);
    public Country() {
        logger.debug("Inside Country Constructor.");
    }
    public String getCode() {
        logger.debug("Inside getCode method.");
        return code;
    }
    public void setCode(String code) {
        logger.debug("Inside setCode method.");
        this.code = code;
    }
    public String getName() {
        logger.debug("Inside getName method.");
        return name;
    }
    public void setName(String name) {
        logger.debug("Inside setName method.");
        this.name = name;
    }
    public String toString() {
        logger.debug("Inside toString method.");
        return "Country [code=" + code + ", name=" + name + "]";
    }
} 