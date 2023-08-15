package dev.vitorvidal.jpaudemy.repository;

import dev.vitorvidal.jpaudemy.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
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
}
