package com.javaguides.springboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SalesDto {
    private Integer quantityOrdered;
    private Long stockId;
}
