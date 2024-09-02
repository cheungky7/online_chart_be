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

    private int quantity;

    @Version
    private int version;

    //Getters and setters omitted for brevity
}