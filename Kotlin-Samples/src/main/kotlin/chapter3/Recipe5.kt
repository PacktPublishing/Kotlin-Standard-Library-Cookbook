package chapter3

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Function composition
 */
fun main(vararg args: String) {
    fun length(word: String) = word.length
    fun isEven(x:Int): Boolean = x.rem(2) == 0
    val isCharCountEven: (word: String) -> Boolean = ::length and ::isEven
    print(isCharCountEven("pneumonoultramicroscopicsilicovolcanoconiosis"))
}

infix fun <P1, R, R2> ((P1) -> R).and(function: (R) -> R2): (P1) -> R2 = {
    function(this(it))
}