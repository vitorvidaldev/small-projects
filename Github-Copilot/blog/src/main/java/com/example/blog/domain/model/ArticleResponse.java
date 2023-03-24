package com.example.blog.domain.model;

import java.util.UUID;

public record ArticleResponse(
        UUID id,
        String title,
        String content,
        String author) {
}
