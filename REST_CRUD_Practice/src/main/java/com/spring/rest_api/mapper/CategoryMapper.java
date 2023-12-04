package com.spring.rest_api.mapper;

import com.spring.rest_api.dto.request.CategoriesRequest;
import com.spring.rest_api.dto.response.CategoriesResponse;
import com.spring.rest_api.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements GenericMapper<Category, CategoriesRequest, CategoriesResponse> {
    @Override
    public Category toEntity(CategoriesRequest categoriesRequest) {
        return Category.builder().catalogId(categoriesRequest.getId())
                .catalogName(categoriesRequest.getName()).description(categoriesRequest.getDescription()).
                priority(categoriesRequest.getPriority()).status(categoriesRequest.isStatus()).build();
    }

    @Override
    public CategoriesResponse toResponse(Category category) {
        return CategoriesResponse.builder().id(category.getCatalogId())
                .name(category.getCatalogName()).description(category.getDescription()).
                priority(category.getPriority()).status(category.isStatus()).build();
    }
}
