package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.StockDto;

import java.util.List;

public interface StockService {
    List<StockDto> getAllStocks();

    void updateStock(Long id, StockDto stockDto);

    void sellStock(Long id, StockDto stockDto);

}
