package com.backend.demo;

import com.backend.demo.controller.EventController;
import com.backend.demo.model.*;
import com.backend.demo.service.EventService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@WebMvcTest(controllers = EventController.class)
public class EventControllerTest {

    @MockBean
    private EventService eventService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("List of all events - /events/all")
    public void listAllEvents() throws Exception {

        Event event1 = new Event(1L, "Open", "Tuska Festival 2021", "Yrjönkatu 30 00100 Helsinki", new Name("Tuska Festival 2021", null, null, null),
                new Location(new Address("Yrjönkatu 30", "00100", "Helsinki")),
                new EventDates("2021-03-02T17:00:00.000Z", null));

        Event event2 = new Event(2L, "Closed", "Eric Clapton", "Areenankuja 1 00240 Helsinki", new Name(null, "Eric Clapton", null, null),
                new Location(new Address("Areenankuja 1", "00240", "Helsinki")),
                new EventDates("2021-05-06T21:01:00.000Z", "2021-05-09T20:59:00.000Z"));

        Mockito.when(eventService.list()).thenReturn(Arrays.asList(event1, event2));

        mockMvc.perform(MockMvcRequestBuilders.get("/events/all"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].e_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].e_id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ename", Matchers.is("Tuska Festival 2021")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ename", Matchers.is("Eric Clapton")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].info", Matchers.is("Open")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].info", Matchers.is("Closed")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].location.address.street_address", Matchers.is("Yrjönkatu 30")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].location.address.street_address", Matchers.is("Areenankuja 1")));

        Mockito.when(eventService.listAmount(2L)).thenReturn(Arrays.asList(event1, event2));

        mockMvc.perform(MockMvcRequestBuilders.get("/events/2"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].e_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].e_id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ename", Matchers.is("Tuska Festival 2021")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ename", Matchers.is("Eric Clapton")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].info", Matchers.is("Open")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].info", Matchers.is("Closed")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].location.address.street_address", Matchers.is("Yrjönkatu 30")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].location.address.street_address", Matchers.is("Areenankuja 1")));

        Mockito.when(eventService.listBetween(1L, 2L)).thenReturn(Arrays.asList(event1, event2));

        mockMvc.perform(MockMvcRequestBuilders.get("/events/1/2"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].e_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].e_id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ename", Matchers.is("Tuska Festival 2021")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ename", Matchers.is("Eric Clapton")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].info", Matchers.is("Open")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].info", Matchers.is("Closed")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].location.address.street_address", Matchers.is("Yrjönkatu 30")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].location.address.street_address", Matchers.is("Areenankuja 1")));

        mockMvc.perform(MockMvcRequestBuilders.get("/events/count"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        mockMvc.perform(MockMvcRequestBuilders.delete("/events/delete/1"))
                .andExpect(MockMvcResultMatchers.status().is(200));


    }
}
