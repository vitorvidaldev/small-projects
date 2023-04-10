package com.example.datarest.entity;

import jakarta.persistence.*;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@RestResource
public class Address {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String location;

    @OneToOne(mappedBy = "address")
    private Library library;

    public Address(long id, String location, Library library) {
        this.id = id;
        this.location = location;
        this.library = library;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
