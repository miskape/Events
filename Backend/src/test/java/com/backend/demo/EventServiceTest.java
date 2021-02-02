package com.backend.demo;

import static org.assertj.core.api.Assertions.assertThat;
import com.backend.demo.model.*;
import com.backend.demo.repository.EventRepository;
import com.backend.demo.service.EventService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class EventServiceTest {

    @Autowired
    private EventService eventService;

    @MockBean
    private EventRepository eventRepository;

    Event e = new Event(2L, null, null, null, new Name("Event 1", null, null, null),
            new Location(new Address("Areenankuja 1", "00240", "Helsinki")),
            new EventDates("2021-05-06T21:01:00.000Z", "2021-05-09T20:59:00.000Z"));

    Event e1 = new Event(1L, null, null, null, new Name(null, "Event 2", null, null),
            new Location(new Address("Yrjönkatu 30", "00100", "Helsinki")),
            new EventDates("2021-03-02T17:00:00.000Z", null));

    Event e2 = new Event(1L, null, null, null, new Name(null, null, "Event 3", null),
            new Location(new Address("Pitsku 13", "00370", "Helsinki")),
            new EventDates("2019-02-02T17:02:00.000Z", "2020-05-09T19:53:00.000Z"));

    @Test
    void save() {
        Mockito.when(eventRepository.save(e)).thenReturn(e);
        assertThat(eventService.save(e)).isEqualTo(e);
    }

    @Test
    void saveAll() {
        List<Event> eventList = new ArrayList<>();
        eventList.add(e);
        eventList.add(e1);
        eventList.add(e2);
        Mockito.when(eventRepository.saveAll(eventList)).thenReturn(eventList);
        assertThat(eventService.saveAll(eventList)).isEqualTo(eventList);
    }

    @Test
    void list() {
        List<Event> eventList = new ArrayList<>();
        eventList.add(e);
        eventList.add(e1);
        eventList.add(e2);
        Mockito.when(eventRepository.findAll()).thenReturn(eventList);
        assertThat(eventService.list()).isEqualTo(eventList);
    }

    @Test
    void listAmount() {
        List<Event> eventList = new ArrayList<>();
        eventList.add(e);
        eventList.add(e1);
        eventList.add(e2);
        Mockito.when(eventRepository.findAllBy(3L)).thenReturn(eventList);
        assertThat(eventService.listAmount((3L)).equals(eventList));
    }

    @Test
    void listBetween() {
        List<Event> eventList = new ArrayList<>();
        eventList.add(e);
        eventList.add(e1);
        eventList.add(e2);
        Mockito.when(eventRepository.findAllBetween(1L, 3L)).thenReturn(eventList);
        assertThat(eventService.listBetween(1L, 3L).equals(eventList));
    }

    @Test
    void setEventInfo() {
        Assert.assertEquals("Closed", eventService.setEventInfo("2021-04-09T16:00:00.000Z", "2021-04-09T16:00:00.000Z"));
        Assert.assertEquals("Open", eventService.setEventInfo("2010-04-09T16:00:00.000Z", "2045-04-09T16:00:00.000Z"));
        Assert.assertEquals("Closed", eventService.setEventInfo(null, null));
        Assert.assertEquals("Open", eventService.setEventInfo("2010-04-09T16:00:00.000Z", null));
        Assert.assertEquals("Closed", eventService.setEventInfo(null, "2021-04-09T16:00:00.000Z"));
    }

    @Test
    void setEventName() {
        Assert.assertEquals("Mikki Hiiri", eventService.setEventName("Mikki Hiiri", null, null, null));
        Assert.assertEquals("Aku Ankka", eventService.setEventName(null, "Aku Ankka", null, null));
        Assert.assertEquals("Nimi 1", eventService.setEventName(null, null, "Nimi 1", "Nimi 2"));
        Assert.assertEquals("Oikea nimi", eventService.setEventName(null, null, null, "Oikea nimi"));
        Assert.assertEquals("Nimi 1", eventService.setEventName("Nimi 1", "Nimi 2", "Nimi 3", "Nimi 4"));
        Assert.assertEquals("No data", eventService.setEventName(null, null, null, null));
    }

    @Test
    void setFullAddress() {
        Assert.assertEquals("No data", eventService.setFullAddress( null, null, null));
        Assert.assertEquals("No data", eventService.setFullAddress( "Toka", null, "testi"));
        Assert.assertEquals("No data", eventService.setFullAddress( "Kolmas", null, null));
        Assert.assertEquals("Neljäs testi", eventService.setFullAddress( "Neljäs", "testi", null));
        Assert.assertEquals("No data", eventService.setFullAddress( null, "testi", "viisi"));
        Assert.assertEquals("Viides testi on viimeinen", eventService.setFullAddress( "Viides", "testi", "on viimeinen"));
    }
}