package chapter9

/**
 * Chapter: Miscellaneous
 * Recipe: Kotlin and JavaScript interoperability issues
 */

fun main(args : Array<String>) {
    showAlert()
}

fun showAlert() {
    val number: dynamic = js("Math.floor(Math.random() * 1000)")
    val message = "There were $number viruses found on your computer! \uD83D\uDE31"
    println("showing alert")
    alert(message)
}

external fun alert(message: Any?): Unit
