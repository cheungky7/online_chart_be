package com.testing.rest_service.controller;

import com.testing.rest_service.domain.entities.Product;
import com.testing.rest_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/search/{id}")
    String searchProduct(@PathVariable Long id){
        //String ret="Return number:"+id;
        Product product=productService.searchProductById(id);

        return product.toString();
    }

}
