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

    private Long waveHouseId;

    // Getters and Setters

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Long getWaveHouseId() {
        return waveHouseId;
    }

    public void setWaveHouseId(Long waveHouseId) {
        this.waveHouseId = waveHouseId;
    }
}