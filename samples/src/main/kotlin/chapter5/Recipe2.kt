package chapter5

import java.time.Instant
import java.util.*

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Exploring the power of Delegation pattern
 */
interface Publication {
    val title: String
    val pageCount: Int
}
class BasePublication(override val title: String,
                      override val pageCount: Int): Publication

class Book(val publicationDate: Instant,
           val author: String,
           val publication: Publication) :
        Publication by publication,
        Rentable {

    override var currentUser: Optional<User> = Optional.empty()
}

class Magazine(val number: Int,
               val publication: Publication) :
        Publication by publication

interface Rentable {
    var currentUser: Optional<User>

    fun availableToRent() = currentUser.isPresent

    fun doRent(user: User): Boolean {
        return if (availableToRent()) {
            currentUser = Optional.of(user)
            true
        } else {
            false
        }
    }
}

interface User {
    val name: String
    val isActive: Boolean
}
open class BaseUser(override val name: String, override val isActive: Boolean): User

class Member(val currentRentals: List<Rentable>,
             user: User) : User by user

class Librarian(user: User) : User by user

fun main(vararg args: String) {
    val book = Book(Instant.now(), "Sam",
            BasePublication("Kotlin Standard Library Cookbook", Integer.MAX_VALUE))

    println("${book.title} written by ${book.author} has ${book.pageCount} pages.")
}


