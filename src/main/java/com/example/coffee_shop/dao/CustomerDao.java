package com.example.coffee_shop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffee_shop.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByUsername(String username);
    Customer findByEmail(String email);
}
