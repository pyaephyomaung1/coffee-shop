package com.example.coffee_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private int id; 
    private String eventName;
    private String eventDate;
    private String eventTime;    
    private String description;
    private int attendes;
    private String customerName;
    private String contactInfo;
}
