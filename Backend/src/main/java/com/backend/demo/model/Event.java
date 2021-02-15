package com.backend.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@JsonFilter("EventsFilter")
public class Event {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "ID")
    private Long e_id;

    private String info;
    private String event_name;
    private String full_address;

    @Embedded
    private Name name;
    @Embedded
    private Location location;
    @Embedded
    private EventDates event_dates;

    public Event(){}

}
