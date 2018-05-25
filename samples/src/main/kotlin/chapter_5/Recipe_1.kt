package chapter_5

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Implementing Strategy pattern
 */

fun main(vararg args: String) {
    val lowerCasePrinter = Printer(lowerCaseFormattingStrategy)
    val upperCasePrinter = Printer(upperCaseFormattingStrategy)

    val text = "This functional-style Strategy pattern looks tasty!"

    lowerCasePrinter.printText(text)
    upperCasePrinter.printText(text)
}

class Printer(val textFormattingStrategy: (String) -> String) {
    fun printText(text: String) {
        val processedText = textFormattingStrategy(text)
        println(processedText)
    }
}

val lowerCaseFormattingStrategy: (String) -> String = {
    it.toLowerCase()
}

val upperCaseFormattingStrategy: (String) -> String = {
    it.toUpperCase()
}