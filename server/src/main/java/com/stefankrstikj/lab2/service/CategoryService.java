package com.stefankrstikj.lab2.service;


import com.stefankrstikj.lab2.model.Category;

import java.util.List;

public interface CategoryService {

    Category create(String name, String description) throws Exception;

    Category update(String name, String description);

    void delete(String name);

    List<Category> listCategories();

    List<Category> searchCategories(String searchText);

}
