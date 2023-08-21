package dev.vitorvidal.jpakotlinexample.repository

import dev.vitorvidal.jpakotlinexample.entity.Course
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
@Transactional
class CourseRepository {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private val entityManager: EntityManager? = null

    fun findById(id: Long?): Course {
        return entityManager!!.find(Course::class.java, id)
    }

    fun deleteById(id: Long?) {
        val course = findById(id)
        entityManager!!.remove(course)
    }

    fun save(course: Course): Course {
        return if (course.id == null) {
            entityManager!!.persist(course)
            course
        } else {
            entityManager!!.merge(course)
        }
    }

    fun playWithEntityManager() {
        logger.info("playWithEntityManager - start")
        val course = Course("Web services course")
        entityManager!!.persist(course)
        course.name = "Web services course updated"
    }
}
