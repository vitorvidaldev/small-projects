package dev.vitorvidal.reviewproject.repositories;

import dev.vitorvidal.reviewproject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
