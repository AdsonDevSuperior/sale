package com.aprendizado.praticarmuito.controller;

import com.aprendizado.praticarmuito.entity.Category;
import com.aprendizado.praticarmuito.entity.Order;
import com.aprendizado.praticarmuito.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @GetMapping
    public List<Order> searchOrders() {
        return service.searchOrdersFindAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrders(@RequestBody Order order) {
        service.createOrder(order);
    }


}

