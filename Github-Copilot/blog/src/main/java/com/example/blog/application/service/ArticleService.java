package com.example.blog.application.service;

import com.example.blog.domain.entity.Article;
import com.example.blog.domain.model.ArticleResponse;
import com.example.blog.domain.model.CreateArticle;
import com.example.blog.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleResponse> getArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(article -> new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor()
        )).toList();
    }

    public ArticleResponse getArticle(UUID id) {
        Article article = articleRepository.findById(id).orElseThrow();
        return new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor()
        );
    }

    public ArticleResponse createArticle(CreateArticle article) {
        Article newArticle = new Article(
                UUID.randomUUID(),
                article.title(),
                article.content(),
                article.author(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        articleRepository.save(newArticle);
        return new ArticleResponse(
                newArticle.getId(),
                newArticle.getTitle(),
                newArticle.getContent(),
                newArticle.getAuthor()
        );
    }

    public ArticleResponse updateArticle(UUID id, CreateArticle article) {
        Article newArticle = new Article(
                id,
                article.title(),
                article.content(),
                article.author(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        articleRepository.save(newArticle);
        return new ArticleResponse(
                newArticle.getId(),
                newArticle.getTitle(),
                newArticle.getContent(),
                newArticle.getAuthor()
        );
    }

    public void deleteArticle(UUID id) {
        articleRepository.deleteById(id);
    }

}
