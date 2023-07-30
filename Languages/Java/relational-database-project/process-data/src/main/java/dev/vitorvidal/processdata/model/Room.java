package dev.vitorvidal.processdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    private String code;
}
