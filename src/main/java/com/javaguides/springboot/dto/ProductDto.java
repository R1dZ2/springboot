package com.javaguides.springboot.dto;

import com.javaguides.springboot.entity.Supplier;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String supplierName;
    private Supplier supplier;
    private Long supplierId;
    private List<StockDto> stockDtoList;
}
