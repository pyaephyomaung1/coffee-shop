package com.example.coffee_shop.services;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.coffee_shop.dao.CustomerDao;
import com.example.coffee_shop.dao.RoleDao;
import com.example.coffee_shop.dto.LoginRequest;
import com.example.coffee_shop.dto.RegisterRequest;
import com.example.coffee_shop.model.Customer;
import com.example.coffee_shop.model.Role;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final CustomerDao customerDao;
    private final RoleDao roleDao;


    @Transactional
    public String register( RegisterRequest registerDto ) {

        Customer customer = new Customer(
            registerDto.getName(),  // Fix: Use getter method
            registerDto.getUsername(),
            passwordEncoder.encode(registerDto.getPassword()),
            registerDto.getEmail()
        );
        Role userRole = roleDao.findByName("ROLE_USER")
        .orElseThrow(() -> new RuntimeException("Role not found: ROLE_USER"));
        customer.addRole(userRole);
        Customer registeredCustomer = customerDao.save(customer);

        return registeredCustomer.getId()+" successfully registered!!";

    }


    public String login( LoginRequest loginDto ) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication( authentication );

        return "successfully login";

    }


}
