package dev.vitorvidal.jpaudemy.repository;

import dev.vitorvidal.jpaudemy.JpaUdemyApplication;
import dev.vitorvidal.jpaudemy.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = JpaUdemyApplication.class)
public class JPQLTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    public void jpql_basic() {
        Query query = entityManager.createQuery("Select c From Course c");
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_typed() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where name like '%100 Steps'",
                Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_named_query() {
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }
}
