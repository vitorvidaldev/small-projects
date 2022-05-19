package com.example.textsearch;

import java.util.List;

public interface SearchRepositoryCustom {

    public List<SearchEntity> searchByFilter(String text);
}
