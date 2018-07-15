package chapter5

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Working with Lazy delegate
 */

fun main(vararg args: String) {

    val coffeMaker: CoffeeMaker by lazy { CoffeeMaker() }

    println("Is the CoffeMaker created already?")

    coffeMaker.makeEspresso()
    coffeMaker.makeAmericano()
}

class CoffeeMaker {

    init {
        println("I'm being created right now... Ready to make some coffe!")
    }

    fun makeEspresso() {
        println("Un espresso, per favore!")
    }

    fun makeAmericano() {
        print("Un caffè americano, per favore!")
    }

}