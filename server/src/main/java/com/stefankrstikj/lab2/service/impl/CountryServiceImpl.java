package com.stefankrstikj.lab2.service.impl;

import com.stefankrstikj.lab2.model.Country;
import com.stefankrstikj.lab2.repository.CountryRepository;
import com.stefankrstikj.lab2.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
