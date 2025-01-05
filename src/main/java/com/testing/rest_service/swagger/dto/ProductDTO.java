package com.testing.rest_service.swagger.dto;

import com.testing.rest_service.domain.entities.ProductSKU;

import java.util.Set;

public class ProductDTO {

    private Long productId;
    private String name;
    private String description;
    private Double basePrice;

    private Set<ProductSKUDTO> skus;

}
