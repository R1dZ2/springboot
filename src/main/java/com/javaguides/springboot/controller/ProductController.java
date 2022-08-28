package com.javaguides.springboot.controller;

import com.javaguides.springboot.entity.Product;
import com.javaguides.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "all")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public String saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Saved...";
    }

    @PutMapping(value = "update/{id}")
    public String updateProduct(@PathVariable long id, @RequestBody Product product){
        productService.updateProduct(id,product);
        return "Updated...";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return "Delete product with the id: "+id;
    }
}