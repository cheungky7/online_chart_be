package com.testing.rest_service.domain.entities;

import jakarta.persistence.Version;

import jakarta.persistence.*;

//stock keeping unit

@Entity
@Table(name = "product_skus")
public class ProductSKU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skuId;

    @Version
    private Long version; // This field enables optimistic locking

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Double price;
    private Integer quantityInStock;

    // Getters and Setters
}