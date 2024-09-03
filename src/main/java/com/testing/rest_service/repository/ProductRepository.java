package com.testing.rest_service.repository;

import com.testing.rest_service.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}
