package com.stefankrstikj.lab2.web.rest;

import com.stefankrstikj.lab2.model.Author;
import com.stefankrstikj.lab2.model.dtos.AuthorDTO;
import com.stefankrstikj.lab2.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    public List<Author> getAll(){
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id){
        return authorService.findById(id);
    }

    @PostMapping("/add")
    public Author create(@RequestBody AuthorDTO authorDTO){
        return authorService.save(authorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        authorService.deleteById(id);
    }
}
