package com.example.coffee_shop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffee_shop.model.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String roleName); 
    
}
