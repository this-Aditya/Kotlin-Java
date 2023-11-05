package l.generics

class Box<T>(t: T) {
    val value: T = t
}

fun main() {
    val box: Box<Int> = Box(786128);
}