package com.cf.cartapp.model.repository;

import com.cf.cartapp.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
