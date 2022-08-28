package com.javaguides.springboot.service.implementation;

import com.javaguides.springboot.entity.Supplier;
import com.javaguides.springboot.repository.SupplierRepository;
import com.javaguides.springboot.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSupplier(){
        return supplierRepository.findAll();
    }
    @Override
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void updateSupplier(Long id,Supplier supplier){
        Supplier updatedSupplier = supplierRepository.findById(id).get();
        updatedSupplier.setSupplierName(supplier.getSupplierName());
        updatedSupplier.setSupplierAddress(supplier.getSupplierAddress());
        updatedSupplier.setSupplierEmailAddress(supplier.getSupplierEmailAddress());
        updatedSupplier.setSupplierTelephoneNumber(supplier.getSupplierTelephoneNumber());
        supplierRepository.save(updatedSupplier);
    }

    @Override
    public void deleteSupplier(Long id){
        Supplier deleteSupplier = supplierRepository.findById(id).get();
        supplierRepository.delete(deleteSupplier);
    }

    @Override
    public Supplier findSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }
}
