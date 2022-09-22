package com.javaguides.springboot.repository;

import com.javaguides.springboot.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
