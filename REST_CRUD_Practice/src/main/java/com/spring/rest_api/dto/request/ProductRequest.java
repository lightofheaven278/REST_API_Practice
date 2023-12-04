package com.spring.rest_api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {
    private String id;
    @NotNull(message = "Product Name is not allowed to be blank!")
    private String name;
    @NotNull(message = "Price is not allowed to be blank!")
    private float price;
    private Date created;
    private int quantity;
    private boolean status;
    @NotNull(message = "catalog ID is not allowed to be blank")
    private long catalogId;
    private String catalogName;
}
