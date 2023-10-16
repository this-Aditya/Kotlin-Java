package b.introduction.e.classes

class InitOrderDemo(name: String) {
    val firstProperty = "First Property: $name".apply (::println)
    init {
        println("Init block that prints $name")
    }
    val secondProperty = "Second property: ${name.length}".also(::println)
    init {
        println("Second INIT block that printd: ${name.length}")
    }
}

fun main() {
    InitOrderDemo("Hello")
}