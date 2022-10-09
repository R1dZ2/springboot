package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.ProductDto;
import com.javaguides.springboot.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    void saveProduct(ProductDto productDto);

    void updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
    ProductDto findProductById(Long id);

    List<ProductDto> findProductByName(String name);

    List<ProductDto> findProductBySupplierName(String supplierName);

    // An optional is a container object which may or may not contain null values.
    // This prevents us from getting null pointer if a value we are looking for is not present in the database.

}
