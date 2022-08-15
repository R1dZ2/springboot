package com.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_NAME",nullable = false)
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;
}
