package com.backend.demo.service;


import com.backend.demo.model.Event;
import com.backend.demo.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;


@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository userRepository) {
        this.eventRepository = userRepository;
    }

    public Iterable<Event> list() {
        return eventRepository.findAll();
    }

    public Iterable<Event> listAmount(Long number) {
        return eventRepository.findAllBy(number);
    }

    public Iterable<Event> listBetween(Long n1, Long n2) {
        return eventRepository.findAllBetween(n1, n2);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    public Long count() {
        return eventRepository.count();
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Iterable<Event> saveAll(List<Event> events) {
        for(int i = 0; i < events.size(); i++){
            events.get(i).setInfo(setEventInfo(
                    events.get(i).getEvent_dates().getStarting_day(),
                    events.get(i).getEvent_dates().getEnding_day()));
            events.get(i).setEName(setEventName(
                    events.get(i).getName().getFi(),
                    events.get(i).getName().getEn(),
                    events.get(i).getName().getSv(),
                    events.get(i).getName().getZh()));
            events.get(i).setFull_address(setFullAddress(
                    events.get(i).getLocation().getAddress().getStreet_address(),
                    events.get(i).getLocation().getAddress().getPostal_code(),
                    events.get(i).getLocation().getAddress().getLocality()));
        }
        return eventRepository.saveAll(events);
    }

    public void deleteAll(){
        eventRepository.deleteAll();
    }


    /**
     * Public so we can test these methods
     */

    // Set event info, determine if event is open or closed
    public String setEventInfo(String start, String end){
        String d = new Date().toInstant().toString();
        Date now = Date.from(Instant.parse(d));
        if(start != null && end != null){
            Date startD = Date.from(Instant.parse(start));
            Date endD = Date.from(Instant.parse(end));
            if(startD.before(now) && now.before(endD)){
                return "Open";
            }else{
                return "Closed";
            }
        }else if(start != null){
            Date startD = Date.from(Instant.parse(start));
            if(startD.before(now)){
                return "Open";
            }else{
                return "Closed";
            }
        }else{
            return "Closed";
        }
    }

    // Find the name of the event, other values should be null
    public String setEventName(String fi, String en, String sv, String zh){
        if(fi != null){
            return fi;
        }else if(en != null){
            return en;
        }else if(sv != null){
            return sv;
        }else if(zh != null){
            return zh;
        }else{
            return "No data";
        }
    }

    public String setFullAddress(String street, String postal, String locality){
        if(street != null && postal != null && locality != null){
            return street + " " + postal + " " + locality;
        }else if(street != null && postal != null){
            return street + " " + postal;
        }else{
            return "No data";
        }
    }
}
