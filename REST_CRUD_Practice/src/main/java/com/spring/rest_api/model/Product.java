package com.spring.rest_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CurrentTimestamp
    private Date created;
    @Column(name = "quantity", columnDefinition = "INTEGER DEFAULT 0")
    private int quantity;
    @Column(name = "status", columnDefinition = "BOOLEAN DEFAULT 1")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id")
    private Category catalog;
}
