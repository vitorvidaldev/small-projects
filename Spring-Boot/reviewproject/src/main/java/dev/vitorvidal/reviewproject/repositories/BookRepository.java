package dev.vitorvidal.reviewproject.repositories;

import dev.vitorvidal.reviewproject.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
