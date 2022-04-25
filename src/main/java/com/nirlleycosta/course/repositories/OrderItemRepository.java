package com.nirlleycosta.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nirlleycosta.course.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
