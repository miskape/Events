package com.backend.demo.controller;


import com.backend.demo.model.Event;
import com.backend.demo.service.EventService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/count")
    public Long count() {
        return eventService.count();
    }

    @DeleteMapping(path = "delete/{id}")
    public void delete(@PathVariable Long id) {
        eventService.deleteEventById(id);
    }

    // Get all the events
    @GetMapping("/all")
    public Iterable<Event> getAllEvents() {
        return eventService.list();
    }

    // Get specific amount of events, starting from id = 1 to {number}
    @GetMapping(path = "{number}")
    public Iterable<Event> getAmountOfEvents(@PathVariable("number") Long number) {
        return eventService.listAmount(number);
    }

    // Select all events between two ids
    @GetMapping(path = "/{n1}/{n2}")
    public Iterable<Event> getEventsBetween(@PathVariable("n1") Long n1, @PathVariable("n2") Long n2) {
        return eventService.listBetween(n1, n2);
    }
}
