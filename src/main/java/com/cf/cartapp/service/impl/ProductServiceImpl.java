package com.cf.cartapp.service.impl;

import com.cf.cartapp.model.entity.Product;
import com.cf.cartapp.model.repository.ProductRepository;
import com.cf.cartapp.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {

        log.info("Get products");

        return productRepository.findAll();
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        log.info("Insert/modify product");
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        log.info("Delete product by id {}", id);
        productRepository.deleteById(id);
    }
}
