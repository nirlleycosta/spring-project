package com.nirlleycosta.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nirlleycosta.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
