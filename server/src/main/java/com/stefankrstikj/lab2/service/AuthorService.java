package com.stefankrstikj.lab2.service;

import com.stefankrstikj.lab2.model.Author;
import com.stefankrstikj.lab2.model.dtos.AuthorDTO;

import java.util.List;

public interface AuthorService {
    Author findById(Long id);

    List<Author> findAll();

    Author save(AuthorDTO authorDTO);

    void deleteById(Long id);

}
