package com.muffincrunchy.marketplace.service.impl;

import com.muffincrunchy.marketplace.model.entity.TransactionDetail;
import com.muffincrunchy.marketplace.repository.TransactionDetailRepository;
import com.muffincrunchy.marketplace.service.TransactionDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {

    private final TransactionDetailRepository transactionDetailRepository;

    @Override
    public List<TransactionDetail> createBulk(List<TransactionDetail> transactionDetails) {
        return transactionDetailRepository.saveAllAndFlush(transactionDetails);
    }
}
