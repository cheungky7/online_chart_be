package com.testing.rest_service.swagger.request;

import com.testing.rest_service.swagger.dto.CategoryDTO;
import com.testing.rest_service.swagger.dto.ProductSKUDTO;

import java.util.Set;

public class CreateProductReq {

   // private Long productId;
    private String name;
    private String description;
    private Double basePrice;

    private Set<CreateProductSKUReq> sKUs;

    private Long categoryId;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Set<CreateProductSKUReq> getsKUs() {
        return sKUs;
    }

    public void setsKUs(Set<CreateProductSKUReq> sKUs) {
        this.sKUs = sKUs;
    }
}
