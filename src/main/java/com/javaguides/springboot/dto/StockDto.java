package com.javaguides.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long id;
    private Integer quantity;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate expiryDate;
    private BigDecimal price;
    private String productName;
    private Long productId;
}
