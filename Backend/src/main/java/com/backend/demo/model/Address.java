package com.backend.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class Address {

    private String street_address;
    private String postal_code;
    private String locality;

    public Address(){}
}
