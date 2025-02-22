package com.testing.rest_service.swagger.dto;

import com.testing.rest_service.domain.entities.Category;
import com.testing.rest_service.domain.entities.ProductSKU;

import java.util.Set;

public class ProductDTO {

    private Long productId;
    private String name;
    private String description;
    private Double basePrice;

    private Set<ProductSKUDTO> skus;

    private CategoryDTO category;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Set<ProductSKUDTO> getSkus() {
        return skus;
    }

    public void setSkus(Set<ProductSKUDTO> skus) {
        this.skus = skus;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
