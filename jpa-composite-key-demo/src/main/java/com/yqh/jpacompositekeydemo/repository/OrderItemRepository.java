package com.yqh.jpacompositekeydemo.repository;

import com.yqh.jpacompositekeydemo.entity.OrderItem;
import com.yqh.jpacompositekeydemo.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}