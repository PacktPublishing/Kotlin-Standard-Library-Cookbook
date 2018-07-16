package chapter9

/**
 * Chapter: Miscellaneous
 * Recipe:
 */

data class A(val a: String = "a") {

    companion object {
        @JvmStatic
        fun foo(): String = "Wooo!"
    }

}