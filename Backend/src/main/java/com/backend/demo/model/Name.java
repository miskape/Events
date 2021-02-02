package com.backend.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class Name {

    private String fi;
    private String en;
    private String sv;
    private String zh;

    public Name(){}
}
