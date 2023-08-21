package dev.vitorvidal.jpakotlinexample.repository;

import dev.vitorvidal.jpakotlinexample.entity.Passport;
import dev.vitorvidal.jpakotlinexample.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class StudentRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    @DirtiesContext
    void shouldSaveStudentAndPassportCorrectly() {
        assertDoesNotThrow(() -> studentRepository.saveStudentWithPassport());
    }

    @Test
    @DirtiesContext
//    @Transactional
    void shouldRetrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 2001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @DirtiesContext
    @Transactional
    void shouldRetrievePassportAndAssociatedStudent() {
        Passport passport = entityManager.find(Passport.class, 3003L);
        logger.info("student -> {}", passport);
        logger.info("passport -> {}", passport.getStudent());
    }
}
