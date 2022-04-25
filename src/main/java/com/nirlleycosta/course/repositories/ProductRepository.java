package com.nirlleycosta.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nirlleycosta.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
