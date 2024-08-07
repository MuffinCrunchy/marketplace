package com.muffincrunchy.marketplace.repository;

import com.muffincrunchy.marketplace.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
