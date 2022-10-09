package com.javaguides.springboot.controller;

import com.javaguides.springboot.dto.ProductDto;
import com.javaguides.springboot.dto.PurchaseDto;
import com.javaguides.springboot.dto.SalesDto;
import com.javaguides.springboot.dto.StockDto;
import com.javaguides.springboot.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    @GetMapping(value = "all")
    public List<StockDto> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<StockDto> getStockById(@PathVariable Long id) {
        return new ResponseEntity<>(stockService.findStockById(id), HttpStatus.OK);
    }

    @PutMapping(value = "update/{id}")
    public String updateStock(@PathVariable Long id, @RequestBody StockDto stockDto) {
        stockService.updateStock(id, stockDto);
        return "updated...";
    }

    @PostMapping(value = "save")
    public String saveStock(@RequestBody StockDto stockDto) {
        stockService.saveStock(stockDto);
        return "Saved...";
    }

    @PutMapping(value = "order")
    public String orderProduct(@RequestBody List<SalesDto> salesDtoList){
        stockService.orderProduct(salesDtoList);
        return "Ordered...";
    }

    @PutMapping(value = "purchase")
    public String purchaseProduct(@RequestBody List<PurchaseDto> purchaseDtoList){
        stockService.purchaseProduct(purchaseDtoList);
        return "Purchased...";
    }
}
