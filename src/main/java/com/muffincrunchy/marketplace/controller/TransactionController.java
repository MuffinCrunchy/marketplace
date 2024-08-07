package com.muffincrunchy.marketplace.controller;

import com.muffincrunchy.marketplace.model.constant.ApiUrl;
import com.muffincrunchy.marketplace.model.dto.request.TransactionRequest;
import com.muffincrunchy.marketplace.model.dto.response.TransactionResponse;
import com.muffincrunchy.marketplace.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ApiUrl.TRANSACTION_URL)
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponse createTransaction(@RequestBody TransactionRequest request) {
        return transactionService.create(request);
    }

    @GetMapping
    public List<TransactionResponse> getAllTransaction(){
        return transactionService.getAll();
    }
}
