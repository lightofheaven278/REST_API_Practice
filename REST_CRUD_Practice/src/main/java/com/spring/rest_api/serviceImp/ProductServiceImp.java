package com.spring.rest_api.serviceImp;

import com.spring.rest_api.dto.request.ProductRequest;
import com.spring.rest_api.dto.response.ProductResponse;
import com.spring.rest_api.mapper.ProductMapper;
import com.spring.rest_api.model.Product;
import com.spring.rest_api.repository.CategoryRepository;
import com.spring.rest_api.repository.ProductRepository;
import com.spring.rest_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> new ProductResponse(product.getProductId(), product.getProductName(),
                product.getPrice(), product.getCreated(), product.getQuantity(),
                product.isStatus(), product.getCatalog().getCatalogId(), product.getProductName())).collect(Collectors.toList());
    }

    @Override
    public ProductResponse addNewProduct(ProductRequest product) {
        Product productNew = new Product(product.getId(), product.getName(), product.getPrice(),
                product.getCreated(), product.getQuantity(), product.isStatus(),
                categoryRepository.findById(product.getCatalogId()).get());
        Product productInsert = productRepository.save(productNew);
        ProductResponse productResponse = productMapper.toResponse(productInsert);
        return ProductResponse.builder().id(productResponse.getId()).name(productResponse.getName()).
                price(productResponse.getPrice()).created(productResponse.getCreated()).
                quantity(productResponse.getQuantity()).status(productResponse.isStatus()).
                catalogId(productResponse.getCatalogId()).
                catalogName(categoryRepository.findById(productResponse.getCatalogId()).get().getCatalogName()).build();
    }

    @Override
    public ProductResponse updateProduct(ProductRequest product, String productId) {
        Product productUpdate = productRepository.findById(productId).get();
        productUpdate.setProductName(product.getName());
        productUpdate.setPrice(product.getPrice());
        productUpdate.setStatus(product.isStatus());
        productUpdate.setCatalog(categoryRepository.findById(product.getCatalogId()).get());
        Product productUpdated = productRepository.save(productUpdate);
        ProductResponse productResponse = productMapper.toResponse(productUpdated);
        return ProductResponse.builder().id(productResponse.getId()).name(productResponse.getName()).
                price(productResponse.getPrice()).created(productResponse.getCreated()).
                quantity(productResponse.getQuantity()).status(productResponse.isStatus()).
                catalogId(productResponse.getCatalogId()).
                catalogName(categoryRepository.findById(product.getCatalogId()).get().getCatalogName()).build();
    }

    @Override
    public ProductResponse deleteProduct(String productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            Product product1 = product.get();
            product1.setStatus(false);
            Product product2 = productRepository.save(product1);
            ProductResponse productResponse = productMapper.toResponse(product2);
            return ProductResponse.builder().id(productResponse.getId()).name(productResponse.getName()).
                    catalogId(productResponse.getCatalogId()).
                    catalogName(categoryRepository.findById(productResponse.getCatalogId()).get().getCatalogName()).
                    build();
        }
        return null;
    }

    @Override
    public ProductResponse searchProduct(String productName) {
        Product product = productRepository.searchProductByProductName(productName);
        ProductResponse productResponse = productMapper.toResponse(product);
        return ProductResponse.builder().id(productResponse.getId()).name(productResponse.getName()).
                price(productResponse.getPrice()).created(productResponse.getCreated()).
                quantity(productResponse.getQuantity()).status(productResponse.isStatus()).
                catalogId(productResponse.getCatalogId()).
                catalogName(categoryRepository.findById(productResponse.getCatalogId()).get().getCatalogName()).build();
    }


}
