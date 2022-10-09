package com.javaguides.springboot.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class PurchaseDto {
    private Integer quantityPurchased;
    private Long productId;
    private BigDecimal price;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate expiryDate;
}
