package com.stefankrstikj.lab2.service.impl;

import com.stefankrstikj.lab2.model.Author;
import com.stefankrstikj.lab2.model.Country;
import com.stefankrstikj.lab2.model.dtos.AuthorDTO;
import com.stefankrstikj.lab2.repository.AuthorRepository;
import com.stefankrstikj.lab2.repository.CountryRepository;
import com.stefankrstikj.lab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(AuthorDTO authorDTO) {
        Country country = countryRepository.findByName(authorDTO.getCountry()).orElseThrow();
        return authorRepository.save(new Author(authorDTO.getName(), authorDTO.getSurname(), country));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
