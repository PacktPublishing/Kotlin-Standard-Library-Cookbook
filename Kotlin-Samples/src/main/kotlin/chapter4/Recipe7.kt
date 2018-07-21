package chapter4

import chapter4.Recipe7.getStudents

/**
 * Chapter: Powerful Data Processing
 * Recipe: Data transformation with map and flatMap
 */
fun main(vararg args: String) {
    fun getLecturesOfCoursesWithSubscribedStudents() =
            getStudents()
                    .flatMap { student ->
                        student.courses
                    }
                    .distinct()
                    .map { course -> course.lecturer }
                    .distinct()
}

object Recipe7 {
    class Course(val name: String, val lecturer: Lecturer, val isPaid: Boolean = false)
    class Student(val name: String, val courses: List<Course>)
    class Lecturer(val name: String)

    fun getStudents(): List<Student> = listOf()
}
