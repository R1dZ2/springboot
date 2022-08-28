package com.javaguides.springboot.controller;

import com.javaguides.springboot.entity.Supplier;
import com.javaguides.springboot.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping(value = "all")
    public List<Supplier> getSupplier(){
        return supplierService.getAllSupplier();
    }

    @GetMapping("{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return new ResponseEntity<>(supplierService.findSupplierById(id), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public String saveSupplier(@RequestBody Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "Saved...";
    }

    @PutMapping(value = "update/{id}")
    public String updateSupplier(@PathVariable long id, @RequestBody Supplier supplier){
        supplierService.updateSupplier(id,supplier);
        return "Updated...";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteSupplier(@PathVariable long id){
        supplierService.deleteSupplier(id);
        return "Delete product with the id: "+id;
    }
}
