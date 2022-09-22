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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Override
    public List<SupplierDto> getAllSupplier() {
        return supplierRepository.findAll().stream().map(supplier -> {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(supplier.getId());
            supplierDto.setName(supplier.getName());
            supplierDto.setTelephoneNumber(supplier.getTelephoneNumber());
            supplierDto.setAddress(supplier.getAddress());
            supplierDto.setEmailAddress(supplier.getEmailAddress());
            return supplierDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void saveSupplier(SupplierDto supplierDto) {
        if (Objects.nonNull(supplierDto)) {
            Supplier supplier = new Supplier();
            supplier.setName(supplierDto.getName());
            supplier.setAddress(supplierDto.getAddress());
            supplier.setTelephoneNumber(supplierDto.getTelephoneNumber());
            supplier.setEmailAddress(supplierDto.getEmailAddress());
            supplierRepository.save(supplier);
        }
    }

    @Override
    public void updateSupplier(Long id, SupplierDto supplierDto) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (Objects.nonNull(supplier)) {
            supplier.setName(supplierDto.getName());
            supplier.setAddress(supplierDto.getAddress());
            supplier.setEmailAddress(supplierDto.getEmailAddress());
            supplier.setTelephoneNumber(supplierDto.getTelephoneNumber());
            supplierRepository.save(supplier);
        }
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
    public SupplierDto findSupplierByName(String name) {
        return supplierRepository.findSupplierByName(name).orElse(null);
    }

    @Override
    public SupplierDto findSupplierByNameAndTelephoneNumber(String name, int telephoneNumber) {
        return supplierRepository.findSupplierByNameAndTelephoneNumber(name, telephoneNumber).orElse(null);
    }

    @Override
    public List<SupplierDto> findSupplierByNameContains(String name) {
        List<SupplierDto> supplierList = supplierRepository.findSupplierByNameContains(name);
        return supplierList;
    }

    @Override
    public List<SupplierDto> findSupplierByEmailAddress(String emailAddress) {
        List<SupplierDto> supplierList = supplierRepository.findSupplierByEmailAddressContains(emailAddress);
        return supplierList;
    }


}
