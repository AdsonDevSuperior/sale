package com.aprendizado.praticarmuito.service;

import com.aprendizado.praticarmuito.entity.Order;
import com.aprendizado.praticarmuito.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private final OrderRepository repository;

    public List<Order> searchOrdersFindAll() {
        return repository.findAll();
    }

    public void createOrder(Order order) {
        repository.save(order);
    }


    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
