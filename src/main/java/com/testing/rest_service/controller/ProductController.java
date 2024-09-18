package com.testing.rest_service.controller;

import com.testing.rest_service.domain.entities.Product;
import com.testing.rest_service.service.ProductService;
import com.testing.rest_service.swagger.AddProductReq;
import com.testing.rest_service.swagger.CreateProductReq;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody AddProductReq addProductReq){
        Product product=productService.addAmountToProduct(addProductReq.getId(),addProductReq.getAddQty());
        return new ResponseEntity<>(product.toString(), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductReq createProductReq){


        productService.createProduct(createProductReq.getId(),createProductReq.getQty());

        Product product=productService.searchProductById(createProductReq.getId());

        return new ResponseEntity<>(product.toString(), HttpStatus.CREATED);
    }

}
