package com.muffincrunchy.marketplace.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TransactionRequest {

    private String customerId;
    private List<TransactionDetailRequest> transactionDetail;
}
