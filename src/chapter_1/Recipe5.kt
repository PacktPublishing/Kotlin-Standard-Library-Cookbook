package chapter_1

/**
 * Discovering concept of sequence
 */
fun main(vararg args: String) {
    val sequence = sequenceOf("a", "b", "c", "d", "e", "f", "g", "h")

    val transformedSequence = sequence.map {
        println("Applying map function for $it")
        it
    }

    println(transformedSequence.take(2).toList())
}