package com.testing.rest_service.controller;

import com.testing.rest_service.domain.entities.Product;
import com.testing.rest_service.service.ProductService;
import com.testing.rest_service.swagger.dto.ProductDTO;
import com.testing.rest_service.swagger.request.CreateProductReq;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//https://www.perplexity.ai/search/db-schema-for-online-shopping-agl1.4s2TEqcoVYcnD9PNw

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    private ModelMapper modelMapper; // Ensure you have ModelMapper configured as a bean

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modelMapper.map(product, ProductDTO.class));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductReq productReq) {
       // Product product = modelMapper.map(productDTO, Product.class);

        Product savedProduct = productService.createProduct(productReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savedProduct, ProductDTO.class));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product updatedProduct = modelMapper.map(productDTO, Product.class);
        updatedProduct = productService.updateProduct(id, updatedProduct);

        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(modelMapper.map(updatedProduct, ProductDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.getProductById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
