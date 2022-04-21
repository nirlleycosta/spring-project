package com.nirlleycosta.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nirlleycosta.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
