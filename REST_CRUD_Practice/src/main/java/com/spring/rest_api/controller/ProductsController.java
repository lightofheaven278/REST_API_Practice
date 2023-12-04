package com.spring.rest_api.controller;

import com.spring.rest_api.dto.request.ProductRequest;
import com.spring.rest_api.dto.response.ProductResponse;
import com.spring.rest_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productsController")
public class ProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProduct")
    public List<ProductResponse> displayAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping("/addNewProduct")
    public ProductResponse addNewProduct(@RequestBody ProductRequest product) {
        return productService.addNewProduct(product);
    }

    @PutMapping("/updateProduct/{productId}")
    public ProductResponse updateProduct(@RequestBody ProductRequest product, @PathVariable String productId) {
        return productService.updateProduct(product, productId);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }
}
