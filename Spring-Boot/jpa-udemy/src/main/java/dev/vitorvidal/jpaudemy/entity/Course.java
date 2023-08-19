package dev.vitorvidal.jpaudemy.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "course")
@NamedQuery(name = "query_get_all_courses", query = "Select c From Course c")
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}