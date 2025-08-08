package com.yqh.jpacompositekeydemo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

    private Integer quantity;
}
