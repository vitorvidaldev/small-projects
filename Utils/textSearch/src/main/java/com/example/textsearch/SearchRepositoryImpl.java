package com.example.textsearch;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class SearchRepositoryImpl implements SearchRepositoryCustom {

    private final MongoClient mongoClient;

    public SearchRepositoryImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public List<SearchEntity> searchByFilter(String text) {
        // You can add codec configuration in your database object. This might be needed to map
        // your object to the mongodb data
        MongoDatabase database = mongoClient.getDatabase("aggregation");
        MongoCollection<Document> collection = database.getCollection("restaurants");

        List<Document> pipeline = List.of(new Document("$search", new Document("index", "default2")
                .append("text", new Document("query", "Many people").append("path", new Document("wildcard", "*")))));

        List<SearchEntity> searchEntityList = new ArrayList<>();
        collection.aggregate(pipeline, SearchEntity.class).forEach(searchEntityList::add);

        return searchEntityList;
    }
}
