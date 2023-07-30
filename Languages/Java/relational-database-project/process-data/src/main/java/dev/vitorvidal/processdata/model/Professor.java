package dev.vitorvidal.processdata.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Employee {
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private Address address;
    private String registration;
    private LocalDate birthDate;
    private LocalDate admissionDate;
    private University university;
    private List<Course> courses;
}
