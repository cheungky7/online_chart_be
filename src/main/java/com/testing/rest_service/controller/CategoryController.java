package com.testing.rest_service.controller;

import com.testing.rest_service.mapper.CategoryMapping;
import com.testing.rest_service.service.CategoryService;
import com.testing.rest_service.swagger.dto.CategoryDTO;
import com.testing.rest_service.domain.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/*
Reference:
https://www.perplexity.ai/search/db-schema-for-online-shopping-agl1.4s2TEqcoVYcnD9PNw

 */

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryMapping categoryMapping;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories().stream()
                .map(category -> categoryMapping.convertToDTO(category))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryMapping.convertToDTO(category));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setCategoryId(null); //set null for new create Category
        Category savedCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapping.convertToDTO(savedCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> editCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        Category updatedCategory =  modelMapper.map(categoryDTO, Category.class);
        updatedCategory = categoryService.editCategory(id, updatedCategory);

        if (updatedCategory == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(modelMapper.map(updatedCategory, CategoryDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Long id) {
        HttpStatus status = categoryService.deleteCategory(id);

        if (status == HttpStatus.NOT_FOUND) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(status);
    }
}
