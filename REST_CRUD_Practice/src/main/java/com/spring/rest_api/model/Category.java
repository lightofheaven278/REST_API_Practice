package com.spring.rest_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private long catalogId;
    @Column(name = "catalog_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String catalogName;
    @Column(name = "description")
    private String description;
    @Column(name = "priority")
    private int priority;
    @Column(name = "status", columnDefinition = "BOOLEAN DEFAULT 1")
    private boolean status;
    @OneToMany(mappedBy = "catalog")
    private List<Product> productList;

}
