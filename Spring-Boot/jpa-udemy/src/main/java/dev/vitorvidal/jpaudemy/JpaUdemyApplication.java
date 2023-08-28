package dev.vitorvidal.jpaudemy;

import dev.vitorvidal.jpaudemy.entity.Course;
import dev.vitorvidal.jpaudemy.entity.Review;
import dev.vitorvidal.jpaudemy.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaUdemyApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaUdemyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // executeTestOperations();
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("5", "Hands-on Stuff"));
        reviews.add(new Review("5", "Dynamic System"));
        courseRepository.addReviewsForCourse(666L, reviews);
    }

    private void executeTestOperations() {
        Course course = courseRepository.findById(10001L);
        logger.info("Course 10001 -> {}", course);


        Course physicsCourse = new Course("Physics");
        logger.info("New course -> {}", courseRepository.save(physicsCourse));
        course.setName("Advanced Physics");
        logger.info("Updating course -> {}", courseRepository.save(course));
        courseRepository.deleteById(10001L);
        logger.info("Deleting course");
    }
}
