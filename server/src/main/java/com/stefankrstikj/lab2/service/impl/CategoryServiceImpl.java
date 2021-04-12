package com.stefankrstikj.lab2.service.impl;

import com.stefankrstikj.lab2.model.enumerations.Category;
import com.stefankrstikj.lab2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    public CategoryServiceImpl() {

    }

    @Override
    public List<Category> listCategories() {
        return List.of(Category.values());
    }

}
