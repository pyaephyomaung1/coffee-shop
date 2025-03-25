package com.example.coffee_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffee_shop.model.Event;

public interface EventDAO extends JpaRepository<Event, Integer> {
    
}
