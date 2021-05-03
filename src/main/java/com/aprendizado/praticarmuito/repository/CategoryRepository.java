package com.aprendizado.praticarmuito.repository;

import com.aprendizado.praticarmuito.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
