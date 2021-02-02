package com.backend.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class EventDates {

    private String starting_day;
    private String ending_day;

    public EventDates(){}
}
