package chapter5

import java.io.File

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Implementing builders the smart way
 */

fun main(vararg args: String) {
    val dialog =
            dialog {

                message {
                    text = "You have 23 viruses on your computer!"
                    color = "#FF0000"
                }

                title {
                    "Warning!"
                }

                image {
                    File.createTempFile("red_alert", "png")
                }
            }

    dialog.show()
}

class Dialog {
    lateinit var title: String

    lateinit var message: String

    lateinit var messageColor: String

    lateinit var image: ByteArray

    fun show() = println("Dialog...\n$this")

    override fun toString(): String = "Title: $title \nImage: $image \nMessage: $message"
}

class DialogBuilder() {
    private var titleHolder = "-"
    private var messageHolder = StyleableText("-", "#000")
    private var imageHolder: File = File.createTempFile("empty", "")

    constructor(initBlock: DialogBuilder.() -> Unit): this() {
        initBlock()
    }

    fun title(block: () -> String) {
        titleHolder = block()
    }

    fun message(block: StyleableText.() -> Unit) {
        messageHolder.apply { block() }
    }

    fun image(block: File.() -> Unit) {
        imageHolder.apply { block() }
    }

    fun build(): Dialog = Dialog().apply {
        title = titleHolder
        message = messageHolder.text
        messageColor = messageHolder.color

        imageHolder.apply {
            image = readBytes()
        }
    }

    class StyleableText(
        var text: String = "",
        var color: String = "#000"
    )
}

fun dialog(block: DialogBuilder.() -> Unit): Dialog = DialogBuilder(block).build()



