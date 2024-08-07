package com.muffincrunchy.marketplace.model.dto.response;

import com.muffincrunchy.marketplace.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class TransactionResponse {

    private String id;
    private User user;
    private Date transactionDate;
    private List<TransactionDetailResponse> transactionDetails;
}
