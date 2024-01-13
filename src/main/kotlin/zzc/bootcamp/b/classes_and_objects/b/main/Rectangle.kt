package zzc.bootcamp.b.classes_and_objects.b.main

class Rectangle (val height: Int, var width: Int = 5, naam: String) {
    val area
        get() = (height * width).also { println("Taken") }

    var name: String = "io"
        set(value) {
            println("BSet $field")
            field = value
            println("Set $field")
        }

//    init {
//        name = "Hello"
//    }

//    constructor(height: Int, width: Int, name: String): this(height, width) {
//        this.name = name
//    }

}

fun main() {
//    val rect = Rectangle(4, 6, "one")
//    println(rect.area)
//    rect.name = "three"
//    println(rect.area)
//    rect.name = "two"
//    rect.width = 4
//    println(rect.area)
    Company()
}


class Company()