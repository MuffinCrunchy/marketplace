package com.muffincrunchy.marketplace.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {

    private String name;
    private Long price;
    private Integer stock;
    private String userId;
}
