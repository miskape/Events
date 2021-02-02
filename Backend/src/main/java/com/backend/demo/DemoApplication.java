package com.backend.demo;


import com.backend.demo.model.Event;

import com.backend.demo.service.EventService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EventService eventService) {
        return args -> {
            // Read JSON and then map wanted data to domain model
            String json = EventJsonReader.simpleHttpRequest();
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
            TypeReference<List<Event>> typeReference = new TypeReference<List<Event>>(){};
            try {
                List<Event> events = mapper.readValue(json,typeReference);
                eventService.saveAll(events);
                System.out.println("Events saved.");
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        };
    }
}
