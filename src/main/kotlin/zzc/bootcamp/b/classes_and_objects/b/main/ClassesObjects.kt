package zzc.bootcamp.b.classes_and_objects.b.main

fun main() {

}

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {

        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
    fun printt() {
//        println(name) Unresolved reference: name
    }
}
