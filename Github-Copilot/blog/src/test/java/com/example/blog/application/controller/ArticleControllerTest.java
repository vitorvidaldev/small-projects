package com.example.blog.application.controller;

import com.example.blog.application.service.ArticleService;
import com.example.blog.domain.model.ArticleResponse;
import com.example.blog.domain.model.CreateArticle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ArticleControllerTest {

    @InjectMocks
    private ArticleController articleController;

    @Mock
    private ArticleService articleService;

    @Test
    void shouldGetArticles() {
        var firstArticle = mock(ArticleResponse.class);
        when(firstArticle.id()).thenReturn(UUID.randomUUID());
        when(firstArticle.title()).thenReturn("first title");
        when(firstArticle.content()).thenReturn("lorem ipsum");
        when(firstArticle.author()).thenReturn("vitor");

        var secondArticle = mock(ArticleResponse.class);
        when(secondArticle.id()).thenReturn(UUID.randomUUID());
        when(secondArticle.title()).thenReturn("second title");
        when(secondArticle.content()).thenReturn("lorem ipsum");
        when(secondArticle.author()).thenReturn("yasha");

        when(articleService.getArticles()).thenReturn(Arrays.asList(firstArticle, secondArticle));

        var response = articleController.getArticles();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());

        verify(articleService, times(1)).getArticles();
    }

    @Test
    void shouldGetArticle() {
        var article = mock(ArticleResponse.class);
        when(article.id()).thenReturn(UUID.randomUUID());
        when(article.title()).thenReturn("first title");
        when(article.content()).thenReturn("lorem ipsum");
        when(article.author()).thenReturn("vitor");

        when(articleService.getArticle(any(UUID.class))).thenReturn(article);

        var response = articleController.getArticle(UUID.randomUUID());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(article.id(), response.getBody().id());
        assertEquals(article.title(), response.getBody().title());
        assertEquals(article.content(), response.getBody().content());
        assertEquals(article.author(), response.getBody().author());

        verify(articleService, times(1)).getArticle(any(UUID.class));
    }

    @Test
    void shouldCreateArticle() {
        var article = mock(ArticleResponse.class);
        when(article.id()).thenReturn(UUID.randomUUID());
        when(article.title()).thenReturn("first title");
        when(article.content()).thenReturn("lorem ipsum");
        when(article.author()).thenReturn("vitor");

        var createArticle = mock(CreateArticle.class);
        when(createArticle.title()).thenReturn("first title");
        when(createArticle.content()).thenReturn("lorem ipsum");
        when(createArticle.author()).thenReturn("vitor");

        when(articleService.createArticle(createArticle)).thenReturn(article);

        var response = articleController.createArticle(createArticle);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(article.id(), response.getBody().id());
        assertEquals(article.title(), response.getBody().title());
        assertEquals(article.content(), response.getBody().content());
        assertEquals(article.author(), response.getBody().author());

        verify(articleService, times(1)).createArticle(createArticle);
    }

    @Test
    void shouldUpdateArticle() {
        var article = mock(ArticleResponse.class);
        when(article.id()).thenReturn(UUID.randomUUID());
        when(article.title()).thenReturn("first title");
        when(article.content()).thenReturn("lorem ipsum");
        when(article.author()).thenReturn("vitor");

        var createArticle = mock(CreateArticle.class);
        when(createArticle.title()).thenReturn("first title");
        when(createArticle.content()).thenReturn("lorem ipsum");
        when(createArticle.author()).thenReturn("vitor");

        when(articleService.updateArticle(any(UUID.class), createArticle)).thenReturn(article);

        var response = articleController.updateArticle(UUID.randomUUID(), createArticle);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(article.id(), response.getBody().id());
        assertEquals(article.title(), response.getBody().title());
        assertEquals(article.content(), response.getBody().content());
        assertEquals(article.author(), response.getBody().author());

        verify(articleService, times(1)).updateArticle(any(UUID.class), createArticle);
    }

    @Test
    void shouldDeleteArticle() {
        doNothing().when(articleService).deleteArticle(any(UUID.class));

        var response = articleController.deleteArticle(UUID.randomUUID());

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(articleService, times(1)).deleteArticle(any(UUID.class));
    }
}