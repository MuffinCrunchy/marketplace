package com.muffincrunchy.marketplace.controller;

import com.muffincrunchy.marketplace.model.dto.constant.ApiUrl;
import com.muffincrunchy.marketplace.model.dto.request.ProductRequest;
import com.muffincrunchy.marketplace.model.entity.Product;
import com.muffincrunchy.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiUrl.PRODUCT_URL)
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<Product> getUsers() {
        return productService.getAll();
    }

    @GetMapping(ApiUrl.ID_PATH)
    public Product getUser(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product createUser(@RequestBody ProductRequest request) {
        return productService.create(request);
    }

    @PutMapping
    public Product updateUser(@RequestBody Product request) {
        return productService.update(request);
    }

    @DeleteMapping("ApiUrl.ID_PATH")
    public void deleteUser(@PathVariable String id) {
        productService.delete(id);
    }
}
