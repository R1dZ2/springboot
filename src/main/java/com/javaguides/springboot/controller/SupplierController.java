package com.javaguides.springboot.controller;

import com.javaguides.springboot.dto.SupplierDto;
import com.javaguides.springboot.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping(value = "all")
    public List<SupplierDto> getSupplier() {
        return supplierService.getAllSupplier();
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable Long id) {
        return new ResponseEntity<>(supplierService.findSupplierById(id), HttpStatus.OK);
    }

    @GetMapping("supplier-name/{name}")
    public ResponseEntity<SupplierDto> getSupplierByName(@PathVariable String name) {
        return new ResponseEntity(supplierService.findSupplierByName(name), HttpStatus.OK);
    }

    @GetMapping("supplier-name-telephone/{name}/{telephoneNumber}")
    public ResponseEntity<List<SupplierDto>> getSupplierByNameAndTelephone(@PathVariable String name, @PathVariable int telephoneNumber) {
        return new ResponseEntity(supplierService.findSupplierByNameAndTelephoneNumber(name, telephoneNumber), HttpStatus.OK);
    }

    @GetMapping("supplier-name-contains/{name}")
    public ResponseEntity<List<SupplierDto>> getSupplierByNameContains(@PathVariable String name) {
        return new ResponseEntity<>(supplierService.findSupplierByNameContains(name), HttpStatus.OK);
    }

    @GetMapping("supplier-email/{emailAddress}")
    public ResponseEntity<List<SupplierDto>> getSupplierByEmailAddress(@PathVariable String emailAddress) {
        return new ResponseEntity<>(supplierService.findSupplierByEmailAddress(emailAddress), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public String saveSupplier(@RequestBody SupplierDto supplierDto) {
        supplierService.saveSupplier(supplierDto);
        return "Saved...";
    }

    @PutMapping(value = "update/{id}")
    public String updateSupplier(@PathVariable long id, @RequestBody SupplierDto supplierDto) {
        supplierService.updateSupplier(id, supplierDto);
        return "Updated...";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteSupplier(@PathVariable long id) {
        supplierService.deleteSupplier(id);
        return "Delete product with the id: " + id;
    }
}
