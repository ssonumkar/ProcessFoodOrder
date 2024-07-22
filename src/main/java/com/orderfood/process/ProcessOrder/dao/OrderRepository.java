package com.orderfood.process.ProcessOrder.dao;

import com.orderfood.process.ProcessOrder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;

@Repository
@Retryable(maxAttempts = 3)
public interface OrderRepository extends JpaRepository<Order, Long> {
}