package chapter2

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Extending functionalities of classes
 */
fun main(vararg args: String) {
    val array: Array<String> = arrayOf("a", "b", "c", "d")
    array.swap("c", "b")
    print(array.joinToString())
}

fun <T> Array<T>.swap(a: T, b: T) {
    val positionA = indexOf(a)
    val positionB = indexOf(b)

    if (positionA < 0 || positionB < 0) {
        throw IllegalArgumentException("Given param doesn't belong to the array")
    }

    val tmp = this[positionA]
    this[positionA] = this[positionB]
    this[positionB] = tmp
}