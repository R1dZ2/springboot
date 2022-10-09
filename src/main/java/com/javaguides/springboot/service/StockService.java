package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.PurchaseDto;
import com.javaguides.springboot.dto.SalesDto;
import com.javaguides.springboot.dto.StockDto;

import java.util.List;

public interface StockService {
    List<StockDto> getAllStocks();

    void updateStock(Long id, StockDto stockDto);

    StockDto findStockById(Long id);

    void saveStock(StockDto stockDto);

    void orderProduct(List<SalesDto> salesDtoList);

    // when purchasing a product create a new stock.
    void purchaseProduct(List<PurchaseDto> purchaseDtoList);
}
