package com.javaguides.springboot.controller;

import com.javaguides.springboot.dto.StockDto;
import com.javaguides.springboot.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    @GetMapping(value = "all")
    public List<StockDto> getAllStocks(){
        return stockService.getAllStocks();
    }

    @PutMapping(value = "update/{id}")
    public String updateStock(@PathVariable Long id, @RequestBody StockDto stockDto){
        stockService.updateStock(id,stockDto);
        return "updated...";
    }
}
