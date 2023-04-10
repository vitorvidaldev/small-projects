package com.example.datarest.entity;

import jakarta.persistence.*;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Entity
@RestResource
public class Library {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    @RestResource(path = "libraryAddress", rel = "address")
    private Address address;

    @OneToOne
    @JoinColumn(name = "secondary_address_id")
    @RestResource(path = "libraryAddress", rel = "address")
    private Address secondaryAddress;

    @OneToMany(mappedBy = "library")
    private List<Book> books;
}
