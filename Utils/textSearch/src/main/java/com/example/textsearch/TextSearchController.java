package com.example.textsearch;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/v1/search")
public class TextSearchController {

    private final SearchService searchService;

    public TextSearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public ResponseEntity<Void> searchText(@RequestBody SearchVO searchVO) {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://search:search@search.8lwnz.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("textSearch");
        MongoCollection<Document> collection = database.getCollection("searchEntity");


        List<Document> documents = List.of(new Document("$search", new Document("index", "default2")
                .append("text", new Document("query", "Many people").append("path", new Document("wildcard", "*")))));

        ArrayList<Document> into = collection.aggregate(documents).into(new ArrayList<>());

        for (Document a : into) {
            log.info(String.valueOf(a.toJson(JsonWriterSettings.builder().indent(true).build())));
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/insert")
    public ResponseEntity<SearchEntity> insertText(@RequestBody SearchVO searchVO) {
        SearchEntity entity = searchService.insertText(searchVO);
        return ResponseEntity.ok(entity);
    }
}
