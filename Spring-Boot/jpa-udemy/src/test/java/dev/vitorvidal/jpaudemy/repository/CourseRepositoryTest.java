package dev.vitorvidal.jpaudemy.repository;

import dev.vitorvidal.jpaudemy.JpaUdemyApplication;
import dev.vitorvidal.jpaudemy.entity.Course;
import dev.vitorvidal.jpaudemy.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = JpaUdemyApplication.class)
class CourseRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;
    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldFindByIdCorrectly() {
        Course course = repository.findById(666L);
        assertEquals(666, course.getId());
        assertEquals("test course", course.getName());
    }

    @Test
    @DirtiesContext
    void shouldDeleteByIdCorrectly() {
        repository.deleteById(1L);
        assertNull(repository.findById(1L));
    }

    @Test
    @DirtiesContext
    void shouldSaveCorrectly() {
        Course course = repository.findById(666L);
        assertEquals("test course", course.getName());
        course.setName("test course updated");
        repository.save(course);

        Course updatedCourse = repository.findById(666L);
        assertEquals("test course updated", updatedCourse.getName());
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(666L);
        logger.info("{}", course.getReviews());
    }

    @Test
    public void retrieveCourseForReview() {
        Review review = entityManager.find(Review.class, 4001L);
        logger.info("{}", review.getCourse());
    }

    @Test
    @DirtiesContext
    @Transactional
    void shouldAddReviewsForCourseCorrectly() {
        Course course = repository.findById(666L);
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

    @Test
    @DirtiesContext
    void shouldPlayWithEntityManager() {
        repository.playWithEntityManager();
    }
}