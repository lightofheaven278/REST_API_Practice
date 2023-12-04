package com.spring.rest_api.service;

import com.spring.rest_api.dto.request.CategoriesRequest;
import com.spring.rest_api.dto.response.CategoriesResponse;

import java.util.List;

public interface CategoryService {
    List<CategoriesResponse> getAllCatalog();

    CategoriesResponse getCatalogById(long catalogId);

    CategoriesResponse addNewCatalog(CategoriesRequest catalog);

    CategoriesResponse updateCatalog(CategoriesRequest catalog, long catalogId);

    CategoriesResponse deleteCatalog(long catalogId);

    CategoriesResponse searchCatalogByName(String catalogName);
}
