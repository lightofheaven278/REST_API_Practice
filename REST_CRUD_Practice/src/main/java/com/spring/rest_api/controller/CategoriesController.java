package com.spring.rest_api.controller;

import com.spring.rest_api.dto.request.CategoriesRequest;
import com.spring.rest_api.dto.response.CategoriesResponse;
import com.spring.rest_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

//    @GetMapping("/getAllCatalog")
//    public ResponseEntity<List<CategoriesResponse>> displayCatalogDTO() {
//        return new ResponseEntity<>(categoryService.getAllCatalog(), HttpStatus.OK);
//    }

    @PostMapping("/addNewCatalog")
    public ResponseEntity<CategoriesResponse> addNewCatalog(@RequestBody CategoriesRequest catalog) {
        return new ResponseEntity<>(categoryService.addNewCatalog(catalog), HttpStatus.CREATED);
    }

    @PutMapping("/updateCatalog/{catalogId}")
    public CategoriesResponse updateCatalog(@RequestBody CategoriesRequest catalog, @PathVariable long catalogId) {
        return categoryService.updateCatalog(catalog, catalogId);
    }

    @DeleteMapping("/deleteCatalog/{catalogId}")
    public ResponseEntity<CategoriesResponse> deleteCatalog(@PathVariable long catalogId) {
        return new ResponseEntity<>(categoryService.deleteCatalog(catalogId), HttpStatus.OK);
    }

    @GetMapping("/searchCatalog")
    public ResponseEntity<CategoriesResponse> searchCatalogByName(@RequestParam String catalogName) {
        return new ResponseEntity<>(categoryService.searchCatalogByName(catalogName), HttpStatus.OK);
    }
}
