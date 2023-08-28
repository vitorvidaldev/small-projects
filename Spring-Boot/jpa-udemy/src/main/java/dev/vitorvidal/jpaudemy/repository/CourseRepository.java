package dev.vitorvidal.jpaudemy.repository;

import dev.vitorvidal.jpaudemy.entity.Course;
import dev.vitorvidal.jpaudemy.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public void addReviewsForCourse() {
        Course course = this.findById(666L);
        logger.info("course.getReviews() -> {}", course.getReviews());

        Review review = new Review("5", "Hands-on Stuff");
        Review review2 = new Review("5", "Hats-off");

        course.addReviews(review);
        review.setCourse(course);

        course.addReviews(review2);
        review2.setCourse(course);

        entityManager.persist(review2);
        entityManager.persist(review);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = this.findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());

        for (Review review : reviews) {
            course.addReviews(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }
}
