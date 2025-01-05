package com.testing.rest_service.swagger.dto;

import com.testing.rest_service.domain.entities.Product;

import java.util.Set;

public class CategoryDTO {

    private Long categoryId;

    private String name;

    private Set<ProductDTO> products;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }
}
