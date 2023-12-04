package com.spring.rest_api.service;


import com.spring.rest_api.dto.request.ProductRequest;
import com.spring.rest_api.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();

    ProductResponse addNewProduct(ProductRequest product);

    ProductResponse updateProduct(ProductRequest product, String productId);

    ProductResponse deleteProduct(String productId);

    ProductResponse searchProduct(String productName);
}
