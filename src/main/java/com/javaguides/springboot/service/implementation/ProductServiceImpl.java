package com.javaguides.springboot.service.implementation;

import com.javaguides.springboot.dto.ProductDto;
import com.javaguides.springboot.entity.Product;
import com.javaguides.springboot.repository.ProductRepository;
import com.javaguides.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    @Override
    public void updateProduct(Long id, Product product) {
        // An optional is a container object which may or may not contain null values.
        // This prevents us from getting null pointer if a value we are looking for is not present in the database.
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(productEntity -> {
            productEntity.setName(product.getName());
            productEntity.setDescription(product.getDescription());
            productRepository.save(productEntity);
        });
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(productEntity -> {
            productRepository.delete(productEntity);
        });
    }

    @Override
    public ProductDto findProductById(Long id) {
        Product productEntity = productRepository.findById(id).orElse(null);
        if (Objects.nonNull(productEntity)) {
            ProductDto productDto = new ProductDto();
            productDto.setId(productEntity.getId());
            productDto.setName(productEntity.getName());
            productDto.setDescription(productEntity.getDescription());
            productDto.setSupplierName(productEntity.getSupplier().getName());
            return productDto;
        } else {
            return null;
        }
    }

    @Override
    public List<ProductDto> findProductByName(String name) {
        List<ProductDto> productList = productRepository.findProductByNameContains(name);
        return productList;
    }
}
