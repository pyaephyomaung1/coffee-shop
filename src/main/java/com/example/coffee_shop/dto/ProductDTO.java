package com.example.coffee_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {    
    private int id;
    private String productName;
    private double price;
    private int quantity;    
    private String description;
    private String ProductImage;
}
