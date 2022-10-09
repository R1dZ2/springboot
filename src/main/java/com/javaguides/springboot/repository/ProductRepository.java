package com.javaguides.springboot.repository;

import com.javaguides.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByNameContains(String name);

    List<Product> findProductBySupplier_Name(String supplierName);
}
