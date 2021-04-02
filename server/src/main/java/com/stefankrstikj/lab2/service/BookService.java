package com.stefankrstikj.lab2.service;

import com.stefankrstikj.lab2.model.Book;
import com.stefankrstikj.lab2.model.dtos.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book findByName(String name);
    Book save(BookDTO bookDTO);
    Book update(BookDTO book);
    void deleteById(Long id);
}
