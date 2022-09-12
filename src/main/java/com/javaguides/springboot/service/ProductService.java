package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.ProductDto;
import com.javaguides.springboot.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void saveProduct(Product product);

    void updateProduct(Long id, Product product);

    void deleteProduct(Long id);
    ProductDto findProductById(Long id);

    List<ProductDto> findProductByName(String name);
}
