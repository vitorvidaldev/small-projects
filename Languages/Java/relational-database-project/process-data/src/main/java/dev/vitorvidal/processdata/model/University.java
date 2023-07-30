package dev.vitorvidal.processdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "university")
public class University {
    private String name;
    private String cnpj;
    private Address address;
    private String phone;
    private String email;
    private String website;
    private Employee rector;
    private Employee viceRector;
}
