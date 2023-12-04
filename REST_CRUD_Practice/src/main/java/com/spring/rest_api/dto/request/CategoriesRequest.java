package com.spring.rest_api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoriesRequest {
    private long id;
    @NotNull(message = "catalog name is not allowed to be blank!")
    @UniqueElements(message = "catalog name must be unique!")
    private String name;
    private String description;
    private int priority;
    private boolean status;
}
