package com.muffincrunchy.marketplace.service;

import com.muffincrunchy.marketplace.model.entity.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {

    List<TransactionDetail> createBulk (List<TransactionDetail> transactionDetails);
}
