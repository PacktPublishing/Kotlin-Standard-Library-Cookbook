package chapter3

import com.google.gson.JsonObject

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Implementing the Either Monad design pattern
 */
fun main(vararg args: String) {
    someGetRequest().fold({
        println(it.message)
    }, {
        println(it.json)
    })
}

fun <V> getEither(action: () -> V): Either<Exception, V> =
        try { Either.right(action()) } catch (e: Exception) { Either.left(e) }

sealed class Either<out L, out R> {
    data class Left<out L>(val left: L) : Either<L, Nothing>()
    data class Right<out R>(val right: R) : Either<Nothing, R>()

    fun <T> fold(leftOp: (L) -> T, rightOp: (R) -> T): T = when (this) {
        is Left -> leftOp(this.left)
        is Right -> rightOp(this.right)
    }

    companion object {
        fun <R> right(value: R): Either<Nothing, R> = Either.Right(value)
        fun <L> left(value: L): Either<L, Nothing> = Either.Left(value)
    }
}

// Sample data models
data class Response(val json: String)
data class ErrorResponse(val code: Int, val message: String)

fun someGetRequest(): Either<ErrorResponse, Response> = Either.left(ErrorResponse(401, "Not authorised"))
