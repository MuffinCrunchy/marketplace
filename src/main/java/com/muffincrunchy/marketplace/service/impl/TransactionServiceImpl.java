package com.muffincrunchy.marketplace.service.impl;

import com.muffincrunchy.marketplace.model.dto.request.TransactionRequest;
import com.muffincrunchy.marketplace.model.dto.response.TransactionDetailResponse;
import com.muffincrunchy.marketplace.model.dto.response.TransactionResponse;
import com.muffincrunchy.marketplace.model.entity.Product;
import com.muffincrunchy.marketplace.model.entity.Transaction;
import com.muffincrunchy.marketplace.model.entity.TransactionDetail;
import com.muffincrunchy.marketplace.model.entity.User;
import com.muffincrunchy.marketplace.repository.TransactionRepository;
import com.muffincrunchy.marketplace.service.ProductService;
import com.muffincrunchy.marketplace.service.TransactionDetailService;
import com.muffincrunchy.marketplace.service.TransactionService;
import com.muffincrunchy.marketplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionDetailService transactionDetailService;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public TransactionResponse create(TransactionRequest request) {
        User user = userService.getById(request.getCustomerId());
        Transaction transaction = Transaction.builder()
                .user(user)
                .transactionDate(new Date())
                .build();
        transactionRepository.saveAndFlush(transaction);
        List<TransactionDetail> transactionDetails = request.getTransactionDetail().stream()
                .map(detailRequest -> {
                    Product product = productService.getById(detailRequest.getProductId());
                    if (product.getStock() - detailRequest.getQuantity() < 0) {
                        throw new RuntimeException("Out of stock");
                    }
                    product.setStock(product.getStock() - detailRequest.getQuantity());
                    user.setPoint(user.getPoint() + 40);

                    return TransactionDetail.builder()
                            .product(product)
                            .transaction(transaction)
                            .quantity(detailRequest.getQuantity())
                            .build();
                }).toList();
        transactionDetailService.createBulk(transactionDetails);
        transaction.setTransactionDetails(transactionDetails);

        List<TransactionDetailResponse> transactionDetailResponse = transactionDetails.stream()
                .map(detail -> TransactionDetailResponse.builder()
                        .id(detail.getId())
                        .product(detail.getProduct())
                        .quantity(detail.getQuantity())
                        .build()).toList();

        return TransactionResponse.builder()
                .id(transaction.getId())
                .user(transaction.getUser())
                .transactionDate(transaction.getTransactionDate())
                .transactionDetails(transactionDetailResponse)
                .build();
    }

    @Override
    public List<TransactionResponse> getAll() {
        List<Transaction> transactions = transactionRepository.findAll();

        return transactions.stream().map(trx -> {
            List<TransactionDetailResponse> trxDetailResponse = trx.getTransactionDetails().stream().map(detail -> TransactionDetailResponse.builder()
                    .id(detail.getId())
                    .product(detail.getProduct())
                    .quantity(detail.getQuantity())
                    .build()).toList();

            return TransactionResponse.builder()
                    .id(trx.getId())
                    .user(trx.getUser())
                    .transactionDate(trx.getTransactionDate())
                    .transactionDetails(trxDetailResponse)
                    .build();
        }).toList();

    }
}
