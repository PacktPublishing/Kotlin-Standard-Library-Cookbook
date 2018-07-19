package chapter2

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Returning multiple data
 */
fun main(vararg args: String) {
    val dividend = 10
    val divisor = 3
    val (quotient, remainder) = divide(dividend, divisor)

    print("$dividend / $divisor = $quotient r $remainder")
}

data class DivisionResult(val quotient: Int, val remainder: Int)

private fun divide(dividend: Int, divisor: Int): DivisionResult {
    val quotient = dividend.div(divisor)
    val remainder = dividend.rem(divisor)
    return DivisionResult(quotient, remainder)
}