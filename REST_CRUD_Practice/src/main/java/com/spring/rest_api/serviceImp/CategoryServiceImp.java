package com.spring.rest_api.serviceImp;

import com.spring.rest_api.dto.request.CategoriesRequest;
import com.spring.rest_api.dto.response.CategoriesResponse;
import com.spring.rest_api.mapper.CategoryMapper;
import com.spring.rest_api.model.Category;
import com.spring.rest_api.repository.CategoryRepository;
import com.spring.rest_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoriesResponse> getAllCatalog() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(catalog -> categoryMapper.toResponse(catalog)).collect(Collectors.toList());
    }

    @Override
    public CategoriesResponse getCatalogById(long catalogId) {
        Optional<Category> otpCat = categoryRepository.findById(catalogId);
        if (otpCat.isPresent()) {
            Category category = otpCat.get();
            CategoriesResponse categoriesResponse = categoryMapper.toResponse(category);
            return CategoriesResponse.builder().id(categoriesResponse.getId()).name(categoriesResponse.getName()).
                    priority(categoriesResponse.getPriority()).build();
        }
        return null;
    }

    @Override
    public CategoriesResponse addNewCatalog(CategoriesRequest catalog) {
        Category catalogNew = new Category(catalog.getId(), catalog.getName(), catalog.getDescription(),
                catalog.getPriority(), catalog.isStatus(), null);
        Category catalogInsert = categoryRepository.save(catalogNew);
        CategoriesResponse addNewCatalogResponse = categoryMapper.toResponse(catalogInsert);
        return CategoriesResponse.builder().name(addNewCatalogResponse.getName()).
                description(addNewCatalogResponse.getDescription()).priority(addNewCatalogResponse.getPriority()).build();
    }

    @Override
    public CategoriesResponse updateCatalog(CategoriesRequest catalog, long catalogId) {
        Category catalogUpdate = categoryRepository.findById(catalogId).get();
        catalogUpdate.setCatalogName(catalog.getName());
        catalogUpdate.setDescription(catalog.getDescription());
        catalogUpdate.setPriority(catalog.getPriority());
        catalogUpdate.setStatus(catalog.isStatus());
        return categoryMapper.toResponse(categoryRepository.save(catalogUpdate));
    }

    @Override
    public CategoriesResponse deleteCatalog(long catalogId) {
        Optional<Category> otpCat = categoryRepository.findById(catalogId);
        if (otpCat.isPresent()) {
            Category catalog = otpCat.get();
            catalog.setStatus(false);
            Category catalogDelete = categoryRepository.save(catalog);
            CategoriesResponse categoriesResponse = categoryMapper.toResponse(catalogDelete);
            return CategoriesResponse.builder().id(categoriesResponse.getId()).name(categoriesResponse.getName()).
                    priority(categoriesResponse.getPriority()).status(categoriesResponse.isStatus()).build();
        }
        return null;
    }

    @Override
    public CategoriesResponse searchCatalogByName(String catalogName) {
        Category categoryList = categoryRepository.findCategoryByCatalogName(catalogName);
        CategoriesResponse categoriesResponses = categoryMapper.toResponse(categoryList);
        return CategoriesResponse.builder().id(categoriesResponses.getId()).name(categoriesResponses.getName()).
                priority(categoriesResponses.getPriority()).status(categoriesResponses.isStatus()).build();
    }


}
