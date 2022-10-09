package com.javaguides.springboot.service.implementation;

import com.javaguides.springboot.dto.PurchaseDto;
import com.javaguides.springboot.dto.SalesDto;
import com.javaguides.springboot.dto.StockDto;
import com.javaguides.springboot.entity.Stock;
import com.javaguides.springboot.repository.ProductRepository;
import com.javaguides.springboot.repository.StockRepository;
import com.javaguides.springboot.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    @Override
    public List<StockDto> getAllStocks() {
        var stockList = stockRepository.findAll();
        var stockDtoList = stockList.stream().map(stock -> {
            StockDto stockDto = new StockDto();
            stockDto.setId(stock.getId());
            stockDto.setProductName(stock.getProduct().getName());
            stockDto.setProductId(stock.getProduct().getId());
            stockDto.setQuantity(stock.getQuantity());
            stockDto.setExpiryDate(stock.getExpiryDate());
            stockDto.setPrice(stock.getPrice());
            return stockDto;
        }).collect(Collectors.toList());
        return stockDtoList;
    }

    @Override
    public void updateStock(Long id, StockDto stockDto) {
        stockRepository.findById(id).ifPresent(stock -> {
            stock.setQuantity(stockDto.getQuantity());
            stock.setPrice(stockDto.getPrice());
            stock.setExpiryDate(stockDto.getExpiryDate());
            productRepository.findById(stockDto.getProductId()).ifPresent(product -> {
                stock.setProduct(product);
            });
            stockRepository.save(stock);
        });
    }

    @Override
    public StockDto findStockById(Long id) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if (Objects.nonNull(stock)) {
            StockDto stockDto = new StockDto();
            stockDto.setId(stock.getId());
            stockDto.setPrice(stock.getPrice());
            stockDto.setQuantity(stock.getQuantity());
            stockDto.setExpiryDate(stock.getExpiryDate());
            stockDto.setProductName(stock.getProduct().getName());
            return stockDto;
        } else {
            return null;
        }
    }

    @Override
    public void saveStock(StockDto stockDto) {
        if (Objects.nonNull(stockDto)) {
            Stock stock = new Stock();
            stock.setExpiryDate(stockDto.getExpiryDate());
            stock.setQuantity(stockDto.getQuantity());
            stock.setPrice(stockDto.getPrice());
            productRepository.findById(stockDto.getProductId()).ifPresent(product -> {
                stock.setProduct(product);
            });
            stockRepository.save(stock);
        }
    }

    @Override
    public void orderProduct(List<SalesDto> salesDtoList) {
        salesDtoList.forEach(salesDto -> {
            stockRepository.findById(salesDto.getStockId()).ifPresent(stock -> {
                stock.setQuantity(stock.getQuantity()-salesDto.getQuantityOrdered());
                stockRepository.save(stock);
            });
        });
    }

    @Override
    public void purchaseProduct(List<PurchaseDto> purchaseDtoList) {
        purchaseDtoList.forEach(purchaseDto -> {
            Stock stock = new Stock();
            stock.setQuantity(purchaseDto.getQuantityPurchased());
            stock.setPrice(purchaseDto.getPrice());
            stock.setExpiryDate(purchaseDto.getExpiryDate());
            productRepository.findById(purchaseDto.getProductId()).ifPresent(product -> {
                stock.setProduct(product);
            });
            stockRepository.save(stock);
        });
    }
}