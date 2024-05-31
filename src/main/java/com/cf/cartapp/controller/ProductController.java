package com.cf.cartapp.controller;

import com.cf.cartapp.model.entity.Product;
import com.cf.cartapp.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/product")
@AllArgsConstructor
@Log4j2
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getProducts() {
        log.info("GET: Get all products");
        List<Product> products = productService.getProducts();

        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/insert")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        log.info("POST: Insert product");
        Product productPersis = productService.saveOrUpdateProduct(product);
        if (productPersis != null) {
            return ResponseEntity.ok(productPersis);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        log.info("PUT: Update product");
        Product productPersis = productService.saveOrUpdateProduct(product);
        if (productPersis != null) {
            return ResponseEntity.ok(productPersis);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        log.info("DELETE: Delete product");
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
