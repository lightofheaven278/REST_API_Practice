package com.spring.rest_api.mapper;

import com.spring.rest_api.dto.request.ProductRequest;
import com.spring.rest_api.dto.response.ProductResponse;
import com.spring.rest_api.model.Product;
import com.spring.rest_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements GenericMapper<Product, ProductRequest, ProductResponse> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product toEntity(ProductRequest productRequest) {
        return Product.builder().productId(productRequest.getId()).productName(productRequest.getName()).
                price(productRequest.getPrice()).created(productRequest.getCreated()).
                quantity(productRequest.getQuantity()).
                catalog(categoryRepository.findById(productRequest.getCatalogId()).get()).
                status(productRequest.isStatus()).build();
    }

    @Override
    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder().id(product.getProductId()).name(product.getProductName()).
                price(product.getPrice()).created(product.getCreated()).quantity(product.getQuantity()).
                catalogId(product.getCatalog().getCatalogId()).status(product.isStatus()).build();
    }
}
