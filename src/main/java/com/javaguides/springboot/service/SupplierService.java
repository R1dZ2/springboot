package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.SupplierDto;
import com.javaguides.springboot.entity.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> getAllSupplier();

    void saveSupplier(Supplier supplier);

    void updateSupplier(Long id, Supplier supplier);

    void deleteSupplier(Long id);

    SupplierDto findSupplierById(Long id);

    Supplier findSupplierByName(String name);

    Supplier findSupplierByNameAndTelephoneNumber(String name, int telephoneNumber);

    List<Supplier> findSupplierByNameContains(String supplierName);

    List<Supplier> findSupplierByEmailAddress(String emailAddress);


}
