package com.aprendizado.praticarmuito.service;

import com.aprendizado.praticarmuito.entity.Product;
import com.aprendizado.praticarmuito.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository repository;

    public List<Product> productFindAll() {
        return repository.findAll();
    }

    public void createProduct(Product product) {
        this.repository.save(product);
    }


    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
