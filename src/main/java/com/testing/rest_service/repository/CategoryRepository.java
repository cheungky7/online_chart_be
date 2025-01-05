package com.testing.rest_service.repository;

import com.testing.rest_service.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.Optional;

public interface  CategoryRepository extends JpaRepository<Category, Long>{

    //Optional<Category> findById(Long id);
}
