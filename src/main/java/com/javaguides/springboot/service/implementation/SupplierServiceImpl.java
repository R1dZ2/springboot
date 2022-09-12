package com.javaguides.springboot.service.implementation;

import com.javaguides.springboot.dto.SupplierDto;
import com.javaguides.springboot.entity.Supplier;
import com.javaguides.springboot.repository.SupplierRepository;
import com.javaguides.springboot.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    @Override
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void updateSupplier(Long id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        optionalSupplier.ifPresent(supplierEntity -> {
            supplierEntity.setName(supplier.getName());
            supplierEntity.setAddress(supplier.getAddress());
            supplierEntity.setEmailAddress(supplier.getEmailAddress());
            supplierEntity.setTelephoneNumber(supplier.getTelephoneNumber());
            supplierRepository.save(supplierEntity);
        });
    }

    @Override
    public void deleteSupplier(Long id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        optionalSupplier.ifPresent(supplierEntity -> {
            supplierRepository.delete(supplierEntity);
        });
    }
/* Not Optional method
    @Override
    public void deleteSupplier(Long id) {
        Supplier deleteSupplier = supplierRepository.findById(id).get();
        supplierRepository.delete(deleteSupplier);
    }
 */

    @Override
    public SupplierDto findSupplierById(Long id) {
        Supplier supplierEntity = supplierRepository.findById(id).orElse(null);
        if (Objects.nonNull(supplierEntity)) {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(supplierEntity.getId());
            supplierDto.setName(supplierEntity.getName());
            supplierDto.setAddress(supplierEntity.getAddress());
            supplierDto.setTelephoneNumber(supplierEntity.getTelephoneNumber());
            supplierDto.setEmailAddress(supplierEntity.getEmailAddress());
            return supplierDto;
        } else {
            return null;
        }
    }

    @Override
    public Supplier findSupplierByName(String name) {
        return supplierRepository.findSupplierByName(name).orElse(null);
    }

    @Override
    public Supplier findSupplierByNameAndTelephoneNumber(String name, int telephoneNumber) {
        return supplierRepository.findSupplierByNameAndTelephoneNumber(name, telephoneNumber).orElse(null);
    }

    @Override
    public List<Supplier> findSupplierByNameContains(String name) {
        List<Supplier> supplierList = supplierRepository.findSupplierByNameContains(name);
        return supplierList;
    }

    @Override
    public List<Supplier> findSupplierByEmailAddress(String emailAddress) {
        List<Supplier> supplierList = supplierRepository.findSupplierByEmailAddressContains(emailAddress);
        return supplierList;
    }


}
