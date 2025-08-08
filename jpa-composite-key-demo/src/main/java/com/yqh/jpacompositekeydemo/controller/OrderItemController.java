package com.yqh.jpacompositekeydemo.controller;

import com.yqh.jpacompositekeydemo.entity.OrderItem;
import com.yqh.jpacompositekeydemo.entity.OrderItemId;
import com.yqh.jpacompositekeydemo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.save(orderItem);
    }

    @GetMapping("/{orderId}/{productId}")
    public ResponseEntity<OrderItem> getOrderItemById(
            @PathVariable Long orderId,
            @PathVariable Long productId) {

        OrderItemId id = new OrderItemId(orderId, productId);
        return orderItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.findAll();
    }

    @DeleteMapping("/{orderId}/{productId}")
    public ResponseEntity<Void> deleteOrderItem(
            @PathVariable Long orderId,
            @PathVariable Long productId) {

        OrderItemId id = new OrderItemId(orderId, productId);
        if (orderItemService.existsById(id)) {
            orderItemService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}