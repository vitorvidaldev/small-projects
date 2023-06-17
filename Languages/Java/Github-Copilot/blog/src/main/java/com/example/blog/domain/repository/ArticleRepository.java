package com.example.blog.domain.repository;

import com.example.blog.domain.entity.Article;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleRepository extends CassandraRepository<Article, UUID> {
}
