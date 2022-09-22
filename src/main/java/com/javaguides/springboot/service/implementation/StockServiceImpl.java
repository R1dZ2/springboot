package com.javaguides.springboot.service.implementation;

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
    public List<StockDto> getAllStocks(){
        var stockList=stockRepository.findAll();
        var stockDtoList=stockList.stream().map(stock -> {
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
        Stock stock = stockRepository.findById(id).orElse(null);
        if (Objects.nonNull(stock)){
            stock.setQuantity(stockDto.getQuantity());
            stock.setPrice(stockDto.getPrice());
            stock.setExpiryDate(stockDto.getExpiryDate());
            productRepository.findById(stockDto.getProductId()).ifPresent(product -> {
                stock.setProduct(product);
            });
            stockRepository.save(stock);
        }

    }

    @Override
    public void sellStock(Long id, StockDto stockDto) {

    }
}
