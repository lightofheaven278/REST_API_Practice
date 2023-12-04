package com.spring.rest_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
    private String id;
    private String name;
    private float price;
    private Date created;
    private int quantity;
    private boolean status;
    private long catalogId;
    private String catalogName;
}
