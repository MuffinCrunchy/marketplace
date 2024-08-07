package com.muffincrunchy.marketplace.service.impl;

import com.muffincrunchy.marketplace.model.dto.request.ProductRequest;
import com.muffincrunchy.marketplace.model.entity.Product;
import com.muffincrunchy.marketplace.repository.ProductRepository;
import com.muffincrunchy.marketplace.service.ProductService;
import com.muffincrunchy.marketplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .user(userService.getById(request.getUserId()))
                .build();
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product update(Product request) {
        getById(request.getId());
        return productRepository.saveAndFlush(request);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
