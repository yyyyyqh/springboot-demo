package com.yqh.jpacompositekeydemo.service;

import com.yqh.jpacompositekeydemo.entity.OrderItem;
import com.yqh.jpacompositekeydemo.entity.OrderItemId;
import com.yqh.jpacompositekeydemo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public Optional<OrderItem> findById(OrderItemId id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public void deleteById(OrderItemId id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public boolean existsById(OrderItemId id) {
        return orderItemRepository.existsById(id);
    }
}