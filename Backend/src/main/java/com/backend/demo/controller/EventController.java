package com.backend.demo.controller;


import com.backend.demo.model.Event;
import com.backend.demo.service.EventService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
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
    public MappingJacksonValue getAllEvents() {
        Iterable<Event> events = eventService.list();
        MappingJacksonValue mappingJacksonValue = getMappingJacksonValue(events);
        return mappingJacksonValue;
    }


    // Get specific amount of events, starting from id = 1 to {number}
    @GetMapping(path = "{number}")
    public MappingJacksonValue getAmountOfEvents(@PathVariable("number") Long number) {
        Iterable<Event> events = eventService.listAmount(number);
        MappingJacksonValue mappingJacksonValue = getMappingJacksonValue(events);
        return mappingJacksonValue;
    }

    // Select all events between two ids
    @GetMapping(path = "/{n1}/{n2}")
    public MappingJacksonValue getEventsBetween(@PathVariable("n1") Long n1, @PathVariable("n2") Long n2) {
        Iterable<Event> events = eventService.listBetween(n1, n2);
        MappingJacksonValue mappingJacksonValue = getMappingJacksonValue(events);
        return mappingJacksonValue;
    }

    // Lets filter events, and only return {"e_id", "info", "event_name", "full_address"}
    private MappingJacksonValue getMappingJacksonValue(Iterable<Event> events) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("e_id", "info", "event_name", "full_address");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EventsFilter", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(events);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
