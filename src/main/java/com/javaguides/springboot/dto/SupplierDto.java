package com.javaguides.springboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class SupplierDto {
    private Long id;
    private String name;
    private String address;
    private int telephoneNumber;
    private String emailAddress;
}
