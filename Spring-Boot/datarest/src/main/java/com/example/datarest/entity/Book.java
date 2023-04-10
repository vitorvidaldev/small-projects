package com.example.datarest.entity;

import jakarta.persistence.*;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Entity
@RestResource
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    public Book(long id, String title, Library library) {
        this.id = id;
        this.title = title;
        this.library = library;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
