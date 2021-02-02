package com.backend.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@Embeddable
public class Location {

    @Embedded
    private Address address;

    public Location(){}
}
