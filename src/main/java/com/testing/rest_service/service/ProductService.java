package com.testing.rest_service.service;

import com.testing.rest_service.domain.entities.Product;
import com.testing.rest_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product searchProductById(Long id){
        Optional<Product> product=productRepository.findById(id);
       Product ret= product.get();
       return ret;
    }



}
