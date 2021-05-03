package com.aprendizado.praticarmuito.repository;

import com.aprendizado.praticarmuito.entity.OrderItem;
import com.aprendizado.praticarmuito.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
