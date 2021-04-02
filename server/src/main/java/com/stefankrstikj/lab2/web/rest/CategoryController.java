package com.stefankrstikj.lab2.web.rest;

import com.stefankrstikj.lab2.model.Category;
import com.stefankrstikj.lab2.model.dtos.CategoryDTO;
import com.stefankrstikj.lab2.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return this.categoryService.listCategories();
    }

    @PostMapping("/add")
    public Category create(@RequestBody CategoryDTO categoryDTO) throws Exception{
        return this.categoryService.create(categoryDTO.getName(), categoryDTO.getDescription() );
    }
}
