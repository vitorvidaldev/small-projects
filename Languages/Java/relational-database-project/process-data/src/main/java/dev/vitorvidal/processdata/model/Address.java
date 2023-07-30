package dev.vitorvidal.processdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
