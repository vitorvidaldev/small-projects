package com.example.datarest.repository;

import com.example.datarest.entity.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}
