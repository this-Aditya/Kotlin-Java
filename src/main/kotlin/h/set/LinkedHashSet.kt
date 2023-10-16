package h.set


/**
 * In Kotlin, when you use the mutableSetOf() function to create a mutable set, you get a LinkedHashSet by default. The LinkedHashSet preserves the order of elements in the set, which means that elements are stored in the order in which they were added.
 *
 * The order of elements is not preserved in hashsets, and it provides O(1) average time complexity for basic operations like add, remove, and contains.
 */


fun main() {
//    first()
//    performInserting()
//    performIteration()
//    performDeletion()

    // LinkedHashSet with 8 capacity and 0.75 load factor
    val numbers: LinkedHashSet<Int> = LinkedHashSet(8, 0.75.toFloat())

    // LinkedHashSet with default capacity and load factor. By default,:
    //the capacity of the linked hash set will be 16
    //the load factor will be 0.75
    val numbers1 = LinkedHashSet<Int>()
}

private fun first(){
    // Creating an arrayList of even numbers
    val evenNumbers = ArrayList<Int>()
    evenNumbers.add(2)
    evenNumbers.add(4)
    println("ArrayList: $evenNumbers")

    // Creating a LinkedHashSet from an ArrayList
    val numbers = LinkedHashSet(evenNumbers)
    println("LinkedHashSet: $numbers")
}

private fun performInserting() {
    val evenNumber = LinkedHashSet<Int>()

    // Using add() method
    evenNumber.add(2)
    evenNumber.add(4)
    evenNumber.add(6)
    println("LinkedHashSet: $evenNumber")

    val numbers = LinkedHashSet<Int>()

    // Using addAll() method
    numbers.add(5)
    numbers.add(6)
    numbers.addAll(evenNumber)
    println("New LinkedHashSet: $numbers")
}

private fun performIteration() {
    val numbers = LinkedHashSet<Int>()
    numbers.add(2)
    numbers.add(5)
    numbers.add(6)
    println("LinkedHashSet: $numbers")

    // Calling the iterator() method
    val iterate: Iterator<Int> = numbers.iterator()

    print("LinkedHashSet using Iterator: ")

    // Accessing elements
    while (iterate.hasNext()) {
        print(iterate.next())
        print(", ")
    }
}

private fun performDeletion() {
    val numbers = LinkedHashSet<Int>()
    numbers.add(2)
    numbers.add(5)
    numbers.add(6)
    numbers.add(7)
    println("LinkedHashSet: $numbers")

    val evenNumbers = LinkedHashSet<Int>()
    evenNumbers.add(2)
    evenNumbers.add(4)

    // Using the remove() method
    val value1 = numbers.remove(5)
    println("Is 5 removed? $value1")

    val value3 = numbers.removeAll(evenNumbers)
    println("Are evens removed: $value3")

    val value2 = numbers.removeAll(numbers)
    println("Are all elements removed? $value2")

}