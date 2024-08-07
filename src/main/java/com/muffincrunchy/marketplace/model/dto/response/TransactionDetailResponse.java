package com.muffincrunchy.marketplace.model.dto.response;

import com.muffincrunchy.marketplace.model.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionDetailResponse {

    private String id;
    private Product product;
    private Integer quantity;
}
