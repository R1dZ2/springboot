package com.javaguides.springboot.dto;

import com.javaguides.springboot.entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class StockDto {
    private long id;
    private Product product;
    private Integer quantity;
    private LocalDate expiryDate;
    private BigDecimal price;
    private String productName;
    private Long productId;
}
