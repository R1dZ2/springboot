package com.javaguides.springboot.controller;

import com.javaguides.springboot.dto.ProductDto;
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
    public List<ProductDto> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }

    @GetMapping("product-name/{productName}")
    public ResponseEntity<List<ProductDto>> getProductByName(@PathVariable String name) {
        return new ResponseEntity<>(productService.findProductByName(name), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public String saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
        return "Saved...";
    }

    @PutMapping(value = "update/{id}")
    public String updateProduct(@PathVariable long id, @RequestBody ProductDto productDto){
        productService.updateProduct(id,productDto);
        return "Updated...";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return "Delete product with the id: "+id;
    }
}