package com.example.coffee_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffee_shop.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {}
