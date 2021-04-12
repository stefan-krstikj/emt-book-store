package com.stefankrstikj.lab2.service.impl;

import com.stefankrstikj.lab2.model.Author;
import com.stefankrstikj.lab2.model.Book;
import com.stefankrstikj.lab2.model.dtos.BookDTO;
import com.stefankrstikj.lab2.model.enumerations.Category;
import com.stefankrstikj.lab2.repository.AuthorRepository;
import com.stefankrstikj.lab2.repository.BookRepository;
import com.stefankrstikj.lab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book findByName(String name) {
        return bookRepository.findByName(name).orElseThrow();
    }

    @Override
    public Book save(BookDTO bookDTO) {
        Category cat = Category.values()[bookDTO.getCategoryId()];
        Author aut = authorRepository.findById(bookDTO.getAuthorId()).orElseThrow();
        return bookRepository.save(new Book(bookDTO.getName(), cat, aut, bookDTO.getAvailableCopies()));
    }


    @Override
    public Book update(BookDTO bookDTO) {
        Book oldBook = bookRepository.findById(bookDTO.getId()).orElseThrow();
        Author author = authorRepository.findById(bookDTO.getAuthorId()).orElseThrow();
        Category category = Category.values()[bookDTO.getCategoryId()];
        oldBook.setAuthor(author);
        oldBook.setAvailableCopies(bookDTO.getAvailableCopies());
        oldBook.setCategory(category);
        oldBook.setName(bookDTO.getName());

        return bookRepository.save(oldBook);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
