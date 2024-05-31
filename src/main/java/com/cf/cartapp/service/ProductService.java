package com.cf.cartapp.service;

import com.cf.cartapp.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);
}
