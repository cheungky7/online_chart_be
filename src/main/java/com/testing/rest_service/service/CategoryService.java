package com.testing.rest_service.service;

import com.testing.rest_service.domain.entities.Category;
import com.testing.rest_service.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> all = categoryRepository.findAll();
        return all;
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category editCategory(Long id, Category category) {
        if (categoryRepository.existsById(id)) {
            category.setCategoryId(id);
            return categoryRepository.save(category);
        }
        return null;
    }

    public HttpStatus deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }
}
