package com.javaguides.springboot.repository;

import com.javaguides.springboot.dto.SupplierDto;
import com.javaguides.springboot.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findSupplierByName(String name);

    Optional<Supplier> findSupplierByNameAndTelephoneNumber(String name, int telephoneNumber);

    List<Supplier> findSupplierByNameContains(String name);

    List<Supplier> findSupplierByEmailAddressContains(String emailAddress);

}
