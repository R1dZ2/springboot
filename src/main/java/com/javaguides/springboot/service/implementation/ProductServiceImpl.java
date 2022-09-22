package com.javaguides.springboot.service.implementation;

import com.javaguides.springboot.dto.ProductDto;
import com.javaguides.springboot.entity.Product;
import com.javaguides.springboot.repository.ProductRepository;
import com.javaguides.springboot.repository.SupplierRepository;
import com.javaguides.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final SupplierRepository supplierRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = productList.stream().map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setDescription(product.getDescription());
            productDto.setSupplierName(product.getSupplier().getName());
            productDto.setSupplierId(product.getSupplier().getId());
            productDto.setId(product.getId());
            return productDto;
        }).collect(Collectors.toList());
        return productDtoList;
    }

    //Front End productDto. Save understand Backend Product
    @Override
    public void saveProduct(ProductDto productDto) {
        if (Objects.nonNull(productDto)) {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            supplierRepository.findById(productDto.getSupplierId()).ifPresent(supplier -> {
                product.setSupplier(supplier);
            });
            productRepository.save(product);
        }
    }

    // An optional is a container object which may or may not contain null values.
    // This prevents us from getting null pointer if a value we are looking for is not present in the database.
//    @Override
//    public void updateProduct(Long id, Product product) {
//        Optional<Product> optionalProduct = productRepository.findById(id);
//        optionalProduct.ifPresent(productEntity -> {
//            productEntity.setName(product.getName());
//            productEntity.setDescription(product.getDescription());
//            productRepository.save(productEntity);
//        });
//    }
    @Override
    public void updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElse(null);
        if (Objects.nonNull(product)) {
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            supplierRepository.findById(productDto.getSupplierId()).ifPresent(supplier -> {
                product.setSupplier(supplier);
            });
            productRepository.save(product);
        }
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
