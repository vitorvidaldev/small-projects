package interfaces

import classes.Course

interface CourseRepository {
    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("course: $course")
        return course.id
    }
}

class SqlCourseRepository : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(1, "Test name", "test author")
    }
}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()

    val course = sqlCourseRepository.getById(1)
    println("Course is $course")
}