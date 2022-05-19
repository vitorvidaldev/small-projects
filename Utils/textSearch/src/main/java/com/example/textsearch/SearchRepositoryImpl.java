package com.example.textsearch;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

public class SearchRepositoryImpl implements SearchRepositoryCustom {

    @Override
    public List<SearchEntity> searchByFilter(String text) {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://search:search@search.8lwnz.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("aggregation");
        MongoCollection<Document> collection = database.getCollection("restaurants");


        List<Document> documents = List.of(new Document("$search", new Document("index", "default2")
                .append("text", new Document("query", "Many people").append("path", new Document("wildcard", "*")))));

        collection.aggregate(documents).forEach(a -> System.out.println(a.toJson()));

        return null;
    }
}
