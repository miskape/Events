package com.backend.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "ID")
    private Long e_id;

    private String info;
    private String eName;
    private String full_address;

    @Embedded
    private Name name;
    @Embedded
    private Location location;
    @Embedded
    private EventDates event_dates;

    public Event(){}

}
