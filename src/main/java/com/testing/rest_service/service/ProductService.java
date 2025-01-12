package com.testing.rest_service.service;

import com.testing.rest_service.domain.entities.Category;
import com.testing.rest_service.domain.entities.Product;
import com.testing.rest_service.domain.entities.ProductSKU;
import com.testing.rest_service.repository.ProductRepository;
import com.testing.rest_service.swagger.request.CreateProductReq;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setProductId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public Product createReqToEntites(CreateProductReq req){

        Product product=new Product();
        product.setBasePrice(req.getBasePrice());
        product.setName(req.getName());
        product.setDescription(req.getDescription());

        Set<ProductSKU> sKUs =req.getSkus().stream()
                .map(sku-> modelMapper.map(sku, ProductSKU.class)) .collect(Collectors.toSet());
        product.setSkus(sKUs);

        Category category=categoryService.getCategoryById(req.getCategoryId());
        product.setCategory(category);

        return product;
    }

    public Product createProduct(CreateProductReq req){
        return this.productRepository.save(createReqToEntites(req));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
