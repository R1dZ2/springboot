package com.javaguides.springboot.repository;

import com.javaguides.springboot.dto.SupplierDto;
import com.javaguides.springboot.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<SupplierDto> findSupplierByName(String name);

    Optional<SupplierDto> findSupplierByNameAndTelephoneNumber(String name, int telephoneNumber);

    List<SupplierDto> findSupplierByNameContains(String name);

    List<SupplierDto> findSupplierByEmailAddressContains(String emailAddress);

}
