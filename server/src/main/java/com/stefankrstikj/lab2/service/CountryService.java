package com.stefankrstikj.lab2.service;

import com.stefankrstikj.lab2.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Country findByName(String name);
    void deleteById(Long id);
}
