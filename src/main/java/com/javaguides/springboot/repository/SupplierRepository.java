package com.javaguides.springboot.repository;

import com.javaguides.springboot.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
