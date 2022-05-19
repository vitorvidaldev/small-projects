package com.example.textsearch;

import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public SearchEntity searchText(SearchVO searchVO) {

        return null;
    }

    public SearchEntity insertText(SearchVO searchVO) {
        return searchRepository.insert(new SearchEntity(searchVO.getText()));
    }
}
