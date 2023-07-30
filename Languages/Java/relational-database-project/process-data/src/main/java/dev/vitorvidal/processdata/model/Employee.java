package dev.vitorvidal.processdata.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private Address address;
    private String registration;
    private University university;
    private LocalDate birthDate;
    private LocalDate admissionDate;
}
