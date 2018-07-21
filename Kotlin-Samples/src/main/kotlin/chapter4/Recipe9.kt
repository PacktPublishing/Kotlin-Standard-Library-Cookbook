package chapter4

/**
 * Chapter: Powerful Data Processing
 * Recipe: Grouping data
 */
fun main(vararg args: String) {

}

object Recipe9 {
    class Course(val name: String, val lecturer: Lecturer, val isPaid: Boolean = false)
    class Student(val name: String, val courses: List<Course>)
    class Lecturer(val name: String)

    fun getStudents(): List<Student> = listOf()


    fun getCoursesWithSubscribedStudents(): Map<Course, List<Student>> =
            getStudents()
                    .flatMap { student ->
                        student.courses.map { course -> course to student }
                    }
                    .groupBy { (course, _) -> course }
                    .map { (course, courseStudentPairs: List<Pair<Course, Student>>) ->
                        course to courseStudentPairs.map { it -> it.second }
                    }
                    .toMap()
}
