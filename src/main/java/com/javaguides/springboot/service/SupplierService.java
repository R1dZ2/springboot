package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    List<SupplierDto> getAllSupplier();

    void saveSupplier(SupplierDto supplierDto);

    void updateSupplier(Long id, SupplierDto supplierDto);

    void deleteSupplier(Long id);

    SupplierDto findSupplierById(Long id);

    SupplierDto findSupplierByName(String name);

    SupplierDto findSupplierByNameAndTelephoneNumber(String name, int telephoneNumber);

    List<SupplierDto> findSupplierByNameContains(String supplierName);

    List<SupplierDto> findSupplierByEmailAddress(String emailAddress);


}
