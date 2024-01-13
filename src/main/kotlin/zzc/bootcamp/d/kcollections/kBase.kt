package zzc.bootcamp.d.kcollections

import java.util.LinkedList

data class Person(var name: String)

fun main() {

//    val list = mutableListOf<Int>(1, 2, 3)
//    val set = setOf<String>("a", "b")
//    val map = mutableMapOf<String, String>("a" to "b").apply {
//        this["a"] = "b"
//    }
//    val listBuild = buildList<Int> {
//        add(1)
//        add(2)
//        addAll(setOf(4, 5, 6))
//    }
//
//    val init = MutableList(3) { it * 2 }
//
//    val ll = LinkedList(listOf(1, 2, 3))
//    ll.add(2)
//
//    val hs = HashSet<Int>(9, 0.8f)
//    println(listBuild.javaClass.simpleName)
//
//    two()

//    val persons = listOf(Person("Aditya"), Person("Abhay"), Person("Aditi"), Person("Alok"))
//    val filtered = persons.toMutableList()
//    filtered[0] = Person("Aman")
//    filtered[0].name = "Aman"
//    println(persons)
three()
}

fun two() {
    val numbers = mutableListOf("one", "two", "three", "four")
    val listIterator = numbers.listIterator()
    listIterator.next()
    listIterator.next()
    listIterator.remove()
    listIterator.add("twos")
    println(numbers)
}

fun three () {
    val list = listOf("one", "two", "three ", "four", "five", "six", "seven", "eight", "nine")
        .asSequence()
        .filter {
            println("Filtering, $it")
            it.length > 3
        }.
        map {
            println("mapping ${it.uppercase()}")
            it.uppercase() }


    println("Entered into the function!!")
    list.forEach(::println)
}