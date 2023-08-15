package com.aaron.supermarket.repositories;

import com.aaron.supermarket.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
