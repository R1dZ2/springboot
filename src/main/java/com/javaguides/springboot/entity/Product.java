package com.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @ManyToOne(targetEntity = Supplier.class)
    @JoinColumn(name = "SUPPLIER_ID",referencedColumnName = "SUPPLIER_ID")
    private Supplier supplier;

    @Column(name = "PRODUCT_NAME",nullable = false)
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;
}
