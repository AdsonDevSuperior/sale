package com.aprendizado.praticarmuito.controller;

import com.aprendizado.praticarmuito.entity.Product;
import com.aprendizado.praticarmuito.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/products")

public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> searchProducts() {
        return service.productFindAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProducts(@RequestBody Product product) {
        service.createProduct(product);
    }
}
