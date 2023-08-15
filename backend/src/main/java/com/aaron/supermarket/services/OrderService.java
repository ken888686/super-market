package com.aaron.supermarket.services;

import com.aaron.supermarket.models.Order;
import com.aaron.supermarket.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }
}
