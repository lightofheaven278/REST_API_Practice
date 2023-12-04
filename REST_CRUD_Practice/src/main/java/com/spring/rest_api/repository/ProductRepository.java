package com.spring.rest_api.repository;

import com.spring.rest_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product searchProductByProductName(String productName);
}
