package com.example.coffee_shop.controller;

import com.example.coffee_shop.dto.EventDTO;
import com.example.coffee_shop.services.EntityService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EntityService entityService;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(entityService.getAllEvents());
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entityService.createEvent(eventDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(
            @PathVariable int id, @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(entityService.updateEvent(id, eventDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable int id) {
        entityService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}