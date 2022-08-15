package com.javaguides.springboot.service.implementation;

import com.javaguides.springboot.entity.Product;
import com.javaguides.springboot.repository.ProductRepository;
import com.javaguides.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
     public List<Product> getAllProducts(){
       return productRepository.findAll();
    }
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id,Product product){
        Product updatedProduct = productRepository.findById(id).get();
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setDescription(product.getDescription());
        productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id){
        Product deleteProduct = productRepository.findById(id).get();
        productRepository.delete(deleteProduct);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
