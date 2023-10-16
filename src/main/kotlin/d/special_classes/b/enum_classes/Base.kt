package d.special_classes.b.enum_classes

import d.special_classes.b.enum_classes.Color.RED

enum class BaseState { IDLE, RUNNING, FINISHED }

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

fun main() {
//    val state = FINISHED
//    val message = when (state) {
//        IDLE -> "Is Idle"
//        RUNNING -> "Is Running"
//        FINISHED -> "Is Finished"
//    }
//    println(message)

    val red = RED
    println(RED)
    println(red.containsRed())
    println(Color.BLUE.containsRed())
    println(Color.YELLOW.containsRed())
}