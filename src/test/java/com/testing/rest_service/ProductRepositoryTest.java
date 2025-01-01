package com.testing.rest_service;


import com.testing.rest_service.domain.entities.Product;
import com.testing.rest_service.repository.ProductRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:test.properties")
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    //@Disabled("Skipping this test for now")
    void testRaceCondition(){
/*
        Product test=new Product(1L, 1000L);

        productRepository.save(test);
        Product test1=productRepository.findById(1l).orElseThrow(()->{throw new RuntimeException("nothing found!");});
        test1.setQuantity(992L);

        Product test2=productRepository.findById(1l).orElseThrow(()->{throw new RuntimeException("nothing found!");});
        productRepository.save(test1);
        test2.setQuantity(1999L);
        productRepository.save(test2);

*/
    }

}
