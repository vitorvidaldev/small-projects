package dev.vitorvidal.jdbcjpaspringudemycourse;

import dev.vitorvidal.jdbcjpaspringudemycourse.entity.Person;
import dev.vitorvidal.jdbcjpaspringudemycourse.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class JdbcJpaSpringUdemyCourseApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(JdbcJpaSpringUdemyCourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", personJdbcDao.findAll());
        logger.info("User id 10001 -> {}", personJdbcDao.findById(10001));
        logger.info("Deleting user 10001. Number of rows deleted -> {}", personJdbcDao.deleteById(10001));
        logger.info("Inserting 10004 -> {}", personJdbcDao.insert(new Person(10004, "Yasha", "Exandria", LocalDateTime.of(1990, 11, 11, 01, 06))));
        logger.info("Updating 10003 -> {}", personJdbcDao.update(new Person(10003, "Pieter", "Berlin", LocalDateTime.now())));
    }
}
