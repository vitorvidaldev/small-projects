package com.example.blog.domain.model;

import java.time.LocalDateTime;

public record CreateArticle(String title, String content, String author, LocalDateTime createdAt) {
}
