package com.javaguides.springboot.dto;

import com.javaguides.springboot.entity.Supplier;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String supplierName;
    private Supplier supplier;
}
