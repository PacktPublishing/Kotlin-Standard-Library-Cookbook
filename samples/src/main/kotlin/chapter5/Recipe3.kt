package chapter5

import java.time.Instant

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Implementing delegated class properties
 */
fun main(vararg args: String) {

}

data class Client(val name: String, val email: String, val creditCards: List<CreditCard>)
data class CreditCard(val holderName: String, val number: String, val cvcCode: String, val expiration: Instant)