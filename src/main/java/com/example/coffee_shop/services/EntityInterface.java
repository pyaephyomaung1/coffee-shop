package com.example.coffee_shop.services;

import java.util.List;

import com.example.coffee_shop.dto.EventDTO;
import com.example.coffee_shop.dto.ProductDTO;

public interface EntityInterface {
    public List<ProductDTO> getAllProducts();
    public List<EventDTO> getAllEvents();

    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(int id, ProductDTO productDTO);
    void deleteProduct(int id);

    EventDTO createEvent(EventDTO eventDTO);
    EventDTO updateEvent(int id, EventDTO eventDTO);
    void deleteEvent(int id);

    ProductDTO getProductById(int id);
    EventDTO getEventById(int id);
}
