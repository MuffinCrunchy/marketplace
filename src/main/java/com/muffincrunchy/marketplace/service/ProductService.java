package com.muffincrunchy.marketplace.service;

import com.muffincrunchy.marketplace.model.dto.request.ProductRequest;
import com.muffincrunchy.marketplace.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product getById(String id);
    Product create(ProductRequest request);
    Product update(Product request);
    void delete(String id);
}
