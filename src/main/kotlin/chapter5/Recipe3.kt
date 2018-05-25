package chapter5

import java.time.Instant

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Implementing delegated class properties
 */
fun main(vararg args: String) {

}

data class Client(val data: Map<String, Any>) {
    val name: String by data
    val email: String by data
    val creditCards: List<CreditCard> by data
}

data class CreditCard(val holderName: String,
                      val number: String,
                      val cvcCode: String,
                      val expiration: Instant)
