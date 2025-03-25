package com.example.coffee_shop.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coffee_shop.dao.EventDAO;
import com.example.coffee_shop.dao.ProductDAO;
import com.example.coffee_shop.dto.EventDTO;
import com.example.coffee_shop.dto.ProductDTO;
import com.example.coffee_shop.model.Event;
import com.example.coffee_shop.model.Product;
import com.example.coffee_shop.utils.EntityUtils;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class EntityService implements EntityInterface {
    private final ProductDAO productDAO;
    private final EventDAO eventDAO;

    // Product CRUD operations
    @Override
    public List<ProductDTO> getAllProducts() {
        return productDAO.findAll().stream().map(EntityUtils::toProductDTO).toList();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = EntityUtils.toProduct(productDTO);
        Product savedProduct = productDAO.save(product);
        return EntityUtils.toProductDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        return productDAO.findById(id)
                .map(existingProduct -> {
                    existingProduct.setProductName(productDTO.getProductName());
                    existingProduct.setPrice(productDTO.getPrice());
                    existingProduct.setQuantity(productDTO.getQuantity());
                    existingProduct.setDescription(productDTO.getDescription());
                    existingProduct.setProductImage(productDTO.getProductImage());

                    Product updatedProduct = productDAO.save(existingProduct);
                    return EntityUtils.toProductDTO(updatedProduct);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteById(id);
    }

    @Override
    public ProductDTO getProductById(int id) {
        return productDAO.findById(id)
                .map(EntityUtils::toProductDTO)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // Event CRUD operations
    @Override
    public List<EventDTO> getAllEvents() {
        return eventDAO.findAll().stream().map(EntityUtils::toEventDTO).toList();
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = EntityUtils.toEvent(eventDTO);
        Event savedEvent = eventDAO.save(event);
        return EntityUtils.toEventDTO(savedEvent);
    }

    @Override
    public EventDTO updateEvent(int id, EventDTO eventDTO) {
        return eventDAO.findById(id)
                .map(existingEvent -> {
                    existingEvent.setEventName(eventDTO.getEventName());
                    existingEvent.setEventDate(LocalDate.parse(eventDTO.getEventDate()));
                    existingEvent.setEventTime(LocalTime.parse(eventDTO.getEventTime()));
                    existingEvent.setDescription(eventDTO.getDescription());
                    existingEvent.setAttendes(eventDTO.getAttendes());
                    existingEvent.setCustomerName(eventDTO.getCustomerName());
                    existingEvent.setContactInfo(eventDTO.getContactInfo());

                    Event updatedEvent = eventDAO.save(existingEvent);
                    return EntityUtils.toEventDTO(updatedEvent);
                })
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    @Override
    public void deleteEvent(int id) {
        eventDAO.deleteById(id);
    }

    @Override
    public EventDTO getEventById(int id) {
        return eventDAO.findById(id)
                .map(EntityUtils::toEventDTO)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }
}