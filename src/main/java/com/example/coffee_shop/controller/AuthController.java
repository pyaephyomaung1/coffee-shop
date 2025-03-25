package com.example.coffee_shop.controller;

import com.example.coffee_shop.services.AuthService;

import org.springframework.web.bind.annotation.*;

import com.example.coffee_shop.dto.LoginRequest;
import com.example.coffee_shop.dto.RegisterRequest;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register (@RequestBody RegisterRequest registerDto) {
        String message = authService.register(registerDto);
        return message;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginDto) {
        String message = authService.login(loginDto);
        return message;
    }
}
