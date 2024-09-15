package com.testing.rest_service.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    private Long id;

    private Long quantity;

    @Version
    private int version;

    public Product() {

    }
    public Product(Long id, Long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", version=" + version +
                '}';
    }

    //Getters and setters omitted for brevity
}