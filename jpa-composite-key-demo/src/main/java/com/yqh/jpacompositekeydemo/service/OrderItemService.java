package com.yqh.jpacompositekeydemo.service;

import com.yqh.jpacompositekeydemo.entity.OrderItem;
import com.yqh.jpacompositekeydemo.entity.OrderItemId;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    OrderItem save(OrderItem orderItem);
    Optional<OrderItem> findById(OrderItemId id);
    List<OrderItem> findAll();
    void deleteById(OrderItemId id);
    boolean existsById(OrderItemId id);
}
