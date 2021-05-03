package com.aprendizado.praticarmuito.repository;

import com.aprendizado.praticarmuito.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
