package com.javaguides.springboot.service;

import com.javaguides.springboot.entity.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> getAllSupplier();

    void saveSupplier(Supplier supplier);

    void updateSupplier(Long id, Supplier supplier);

    void deleteSupplier(Long id);
    Supplier findSupplierById(Long id);
}
