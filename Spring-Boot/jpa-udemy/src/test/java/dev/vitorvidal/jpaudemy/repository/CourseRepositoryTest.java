package dev.vitorvidal.jpaudemy.repository;

import dev.vitorvidal.jpaudemy.JpaUdemyApplication;
import dev.vitorvidal.jpaudemy.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = JpaUdemyApplication.class)
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;

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
    @DirtiesContext
    void shouldPlayWithEntityManager() {
        repository.playWithEntityManager();
    }
}