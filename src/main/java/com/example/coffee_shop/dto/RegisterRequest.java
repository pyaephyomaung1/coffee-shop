package com.example.coffee_shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequest {
        private String name;
        private String username;
        private String password;
        private String email;
    

        public RegisterRequest(String name, String username, String password, String email) {
            this.name = name;
            this.username = username;
            this.password = password;
        }
    

    }