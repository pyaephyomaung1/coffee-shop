package com.example.coffee_shop.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.coffee_shop.dto.EventDTO;
import com.example.coffee_shop.dto.ProductDTO;
import com.example.coffee_shop.model.Event;
import com.example.coffee_shop.model.Product;

public class EntityUtils {
    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getQuantity(),
                product.getDescription(),
                product.getProductImage());
    }

    public static Product toProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.getId(),
                productDTO.getProductName(),
                productDTO.getPrice(),
                productDTO.getQuantity(),
                productDTO.getDescription(),
                productDTO.getProductImage());
    }

    public static EventDTO toEventDTO(Event event) {
        String eventDate = event.getEventDate().toString();
        String eventTime = event.getEventTime().toString();
        return new EventDTO(
                event.getId(),
                event.getEventName(),
                eventDate,
                eventTime,
                event.getDescription(),
                event.getAttendes(),
                event.getCustomerName(),
                event.getContactInfo());
    }

    public static Event toEvent(EventDTO eventDTO) {
        LocalDate eventDate = LocalDate.parse(eventDTO.getEventDate());
        LocalTime eventTime = LocalTime.parse(eventDTO.getEventTime());
        return new Event(
                eventDTO.getId(),
                eventDTO.getEventName(),
                eventDate,
                eventTime,
                eventDTO.getDescription(),
                eventDTO.getAttendes(),
                eventDTO.getCustomerName(),
                eventDTO.getContactInfo());
    }
}
