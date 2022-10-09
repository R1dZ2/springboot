package com.javaguides.springboot.repository;

import com.javaguides.springboot.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Long> {
    List<Stock> findStockByProduct_Id(Long productId);
}
