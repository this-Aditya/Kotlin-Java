package b.introduction.c.generics

class Base<E> (vararg items: E) {
    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun pop() = elements.removeAt(elements.size -1)

    fun peek() = elements.last()

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size
    override fun toString(): String = elements.joinToString(", ")
}

fun main() {
    val first = Base("One", "Two", "Three", "Four", "Five")
    val second = Base(1,2,3,4,5,6,7)
    val third = Base(1.0,2.0,3.0,4.0,5.0)
    println("First: $first")
    println("Second peek: ${second.peek()}")
    println("Third Pop: ${third.pop()}")
    println("List: $third")
    println("Third Pop: ${third.pop()}")
    println("List: $third")
    println("Third Pop: ${third.pop()}")
    println("List: $third")
}