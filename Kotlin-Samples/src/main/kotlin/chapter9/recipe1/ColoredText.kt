package chapter9.recipe1

import java.awt.Color
/**
 * Chapter: Miscellaneous
 * Recipe:
 */

data class ColoredText
@JvmOverloads
constructor(
        var text: String = "",
        var color: Color = defaultColor) {

    fun printToConsole() = println(text)

    companion object {
        @JvmField
        val defaultColor = Color.BLUE

        @JvmStatic
        fun processText(text: String): String =
                with(text) {
                    toLowerCase().trim().capitalize()
                }

    }

}