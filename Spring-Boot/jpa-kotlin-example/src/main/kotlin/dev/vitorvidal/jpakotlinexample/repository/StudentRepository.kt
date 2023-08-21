package dev.vitorvidal.jpakotlinexample.repository

import dev.vitorvidal.jpakotlinexample.entity.Passport
import dev.vitorvidal.jpakotlinexample.entity.Student
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
@Transactional
class StudentRepository {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private val entityManager: EntityManager? = null
    fun findById(id: Long?): Student {
        return entityManager!!.find(Student::class.java, id)
    }

    fun deleteById(id: Long?) {
        val student = findById(id)
        entityManager!!.remove(student)
    }

    fun save(student: Student): Student {
        return if (student.id == null) {
            entityManager!!.persist(student)
            student
        } else {
            entityManager!!.merge(student)
        }
    }

    fun saveStudentWithPassport() {
        val passport = Passport(null, "4985", null, null, null)
        entityManager!!.persist(passport)
        val student = Student(null, "Arianne", passport, null, null)
        student.passport = passport
        entityManager.persist(student)
    }

    fun playWithEntityManager() {
        logger.info("playWithEntityManager - start")
        val student = Student(null, "Web services student", null, null, null)
        entityManager!!.persist(student)
        student.name = "Web services student updated"
    }
}
