package com.aprendizado.praticarmuito.controller;

import com.aprendizado.praticarmuito.entity.Category;
import com.aprendizado.praticarmuito.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/categories")
public class CategoryController {

    final private CategoryService service;

    @GetMapping("/category")
    public List<Category> searchUsers() {
        return service.categoryListFindAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Category categoryId(@PathVariable ("id") Long id, @RequestBody Category category) {
        return service.findById(category, id);
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody Category category){
        service.saveCategories(category);
    }

    @PutMapping("/id")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable ("id") Long id, @RequestBody Category category) {
        this.service.updateCategory(category, id);
    }
}
