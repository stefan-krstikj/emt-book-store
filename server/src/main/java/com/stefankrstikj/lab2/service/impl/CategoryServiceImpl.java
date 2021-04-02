package com.stefankrstikj.lab2.service.impl;

import com.stefankrstikj.lab2.model.Category;
import com.stefankrstikj.lab2.repository.CategoryRepository;
import com.stefankrstikj.lab2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String name, String description) throws Exception {
        if(name == null || name.length() == 0 || description == null || description.length() == 0)
            throw new Exception("Name and description must not be empty");
        return categoryRepository.save(new Category(name, description));
    }

    @Override
    public Category update(String name, String description) {
        Category oldCategory = categoryRepository.findByNameLike(name).orElseThrow();
        oldCategory.setName(name);
        oldCategory.setDescription(description);
        return categoryRepository.save(oldCategory);
    }

    @Override
    public void delete(String name) {
        Category category = categoryRepository.findByNameLike(name).orElseThrow();
        categoryRepository.delete(category);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return categoryRepository.findAllByNameLike(searchText);
    }
}
