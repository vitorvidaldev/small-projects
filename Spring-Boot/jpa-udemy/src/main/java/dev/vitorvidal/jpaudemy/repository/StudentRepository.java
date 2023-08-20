package dev.vitorvidal.jpaudemy.repository;

import dev.vitorvidal.jpaudemy.entity.Passport;
import dev.vitorvidal.jpaudemy.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
            return student;
        } else {
            return entityManager.merge(student);
        }
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("4985");
        entityManager.persist(passport);
        Student student = new Student("Arianne");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void playWithEntityManager() {
        logger.info("playWithEntityManager - start");
        Student student = new Student("Web services student");
        entityManager.persist(student);
        student.setName("Web services student updated");
    }
}
