package h.set

import java.util.*


fun basicHashSet() {
    /**Creating a set using mutableSetOf, by default it is using [LinkedHashSet]*/
    val set1: MutableSet<Int> = mutableSetOf()

    // Add elements to set1
    set1.add(2)
    set1.add(3)
    println("Set1: $set1")

    // Creating another set using the HashSet class
    val set2: MutableSet<Int> = HashSet<Int>()

    // Add elements
    set2.add(1)
    set2.add(2)
    println("Set2: $set2")

    // Union of two sets
    set2.addAll(set1)
    println("Union is: $set2")
}

fun main() {
basicTreeSet()
}


fun basicTreeSet() {
    val numbers: MutableSet<Int> = TreeSet<Int>()

    numbers.add(1)
    numbers.add(2)
    numbers.add(3)

    println("Set using tree set: $numbers")

    // Access Elements using iterator()
    print("Accessing elements using iterator(): ")
    val iterate: Iterator<Int> = numbers.iterator()
    while (iterate.hasNext()) {
        print(iterate.next())
        print(", ")
    }

}



