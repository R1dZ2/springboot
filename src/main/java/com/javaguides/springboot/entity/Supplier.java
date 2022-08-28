package com.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {
    @Id
    @GeneratedValue
    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Id
    @Column(name = "SUPPLIER_NAME")
    private String supplierName;

    @Id
    @Column(name = "SUPPLIER_ADDRESS")
    private String supplierAddress;

    @Id
    @Column(name = "SUPPLIER_TELEPHONE_NUMBER")
    private int supplierTelephoneNumber;

    @Column(name = "SUPPLIER_EMAIL_ADDRESS")
    private String supplierEmailAddress;

    @OneToMany(mappedBy = "supplier",fetch = FetchType.LAZY)
    List<Product> products;

}
