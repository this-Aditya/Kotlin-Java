package c.control_flow.a.when_expr

class Base {

}

fun case(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Hello")
        is Long -> println("Long")
        is String -> println("Is a String, but not `Hello`")
        !is String -> println("Not a string")
        else -> println("Unnown parameter")
    }
}

fun assign(obj: Any): Any = when(obj) {
    1 -> "One"
    "hello" -> 1
    is Long ->false
    else -> 42
}

fun main() {
//    case(1)
//    case("Hello")
//    case(3L)
//    case("Yo")
//    case(1.2)
    println(assign(1))
    println(assign("hello"))
    println(assign(23L))
    println(assign(2.3))
}