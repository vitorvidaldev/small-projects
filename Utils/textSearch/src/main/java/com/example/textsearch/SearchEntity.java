package com.example.textsearch;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SearchEntity {
    private ObjectId id;

    @TextIndexed
    private String text;

    public SearchEntity(String text) {
        this.id = new ObjectId();
        this.text = text;
    }
}
