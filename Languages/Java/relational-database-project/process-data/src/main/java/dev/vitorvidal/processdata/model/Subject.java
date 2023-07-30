package dev.vitorvidal.processdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
    private String name;
    private String code;
    private String description;
    private String bibliography;
    private Professor professor;
    private Course course;
    private Room room;
}
