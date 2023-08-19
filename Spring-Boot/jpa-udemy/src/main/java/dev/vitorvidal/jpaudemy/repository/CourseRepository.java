package dev.vitorvidal.jpaudemy.repository;

import dev.vitorvidal.jpaudemy.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
            return course;
        } else {
            return entityManager.merge(course);
        }
    }

    public void playWithEntityManager() {
        logger.info("playWithEntityManager - start");
        Course course = new Course("Web services course");
        entityManager.persist(course);
        course.setName("Web services course updated");
    }
}
