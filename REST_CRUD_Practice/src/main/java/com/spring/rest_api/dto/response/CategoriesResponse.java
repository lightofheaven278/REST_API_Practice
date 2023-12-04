package com.spring.rest_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.MetadataBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoriesResponse {
    private long id;
    private String name;
    private String description;
    private int priority;
    private boolean status;
}
