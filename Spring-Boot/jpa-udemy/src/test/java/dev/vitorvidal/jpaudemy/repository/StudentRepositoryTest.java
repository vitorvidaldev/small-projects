package dev.vitorvidal.jpaudemy.repository;

import dev.vitorvidal.jpaudemy.JpaUdemyApplication;
import dev.vitorvidal.jpaudemy.entity.Passport;
import dev.vitorvidal.jpaudemy.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(classes = JpaUdemyApplication.class)
public class StudentRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldSaveStudentAndPassportCorrectly() {
        assertDoesNotThrow(() -> studentRepository.saveStudentWithPassport());
    }

    @Test
    @Transactional
    void shouldRetrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 2001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    void shouldRetrievePassportAndAssociatedStudent() {
        Passport passport = entityManager.find(Passport.class, 3003L);
        logger.info("student -> {}", passport);
        logger.info("passport -> {}", passport.getStudent());
    }
}
