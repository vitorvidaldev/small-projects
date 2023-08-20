package dev.vitorvidal.jpaudemy.queries;

import dev.vitorvidal.jpaudemy.JpaUdemyApplication;
import dev.vitorvidal.jpaudemy.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = JpaUdemyApplication.class)
public class NativeQueriesTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    public void native_queries_basic() {
        Query query = entityManager.createNativeQuery("select * from course");
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void native_queries_with_parameter() {
        Query query = entityManager.createNativeQuery("select * from course where id = ?", Course.class);
        query.setParameter(1, 10001L);
        List resultList = query.getResultList();
        logger.info("select * from course where id = ? -> {}", resultList);
    }

    @Test
    public void native_queries_with_named_parameter() {
        Query query = entityManager.createNativeQuery("select * from course where id = :id", Course.class);
        query.setParameter("id", 10001L);
        List resultList = query.getResultList();
        logger.info("select * from course where id = ? -> {}", resultList);
    }
}
