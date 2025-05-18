package com.likelion.likelionassignmentcrud.product.domain.repository;

import com.likelion.likelionassignmentcrud.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}