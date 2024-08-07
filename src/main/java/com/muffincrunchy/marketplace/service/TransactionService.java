package com.muffincrunchy.marketplace.service;

import com.muffincrunchy.marketplace.model.dto.request.TransactionRequest;
import com.muffincrunchy.marketplace.model.dto.response.TransactionResponse;

import java.util.List;

public interface TransactionService {

    TransactionResponse create(TransactionRequest request);
    List<TransactionResponse> getAll();
}
