package com.testing.rest_service.service;

import com.testing.rest_service.domain.entities.Product;
import com.testing.rest_service.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product searchProductById(Long id){
        Optional<Product> product=productRepository.findById(id);
       Product ret= product.get();
       return ret;
    }


    @Transactional
    public Product addAmountToProduct(Long id,Long addQty){

        Product product=productRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Product not found")
        );

        Long qty=product.getQuantity();
        qty=qty+addQty;
        product.setQuantity(qty);

        Product modifiedProduct=productRepository.save(product);
        return modifiedProduct;

    }

    @Transactional
    public void createProduct(Long id,Long qty){
        Product newPrd=new Product(id,qty);
        productRepository.save(newPrd);
    }



}
