package com.javaguides.springboot.repository;

import com.javaguides.springboot.dto.ProductDto;
import com.javaguides.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<ProductDto> findProductByNameContains(String name);
}
