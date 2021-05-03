package com.aprendizado.praticarmuito.service;

import com.aprendizado.praticarmuito.entity.Category;
import com.aprendizado.praticarmuito.entity.Order;
import com.aprendizado.praticarmuito.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    final private CategoryRepository repository;

    public List<Category> categoryListFindAll() {
        return repository.findAll();
    }

    public Category findById(Category category, Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

    public void saveCategories(Category category) {
        repository.save(category);

    }

    public void updateCategory(Category category, Long id) {
        Category categorySale = repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "erro ao pesquisar id"));

        BeanUtils.copyProperties(category, categorySale,"id");
        this.repository.save(categorySale);

    }
}

