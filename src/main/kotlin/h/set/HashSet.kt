package h.set


/**
 * Why HashSet?
 *
 * In Kotlin, HashSet is commonly used if we have to access elements randomly. It is because elements in a hash table are accessed using hash codes.
 *
 * The hashcode of an element is a unique identity that helps to identify the element in a hash table.
 *
 * HashSet cannot contain duplicate elements. Hence, each hash set element has a unique hashcode.
 *
 * Note: HashSet is not synchronized. That is if multiple threads access the hash set at the same time and one of the threads modifies the hash set. Then it must be externally synchronized.
 */

private fun main() {
//    first()
//    second()
//    unionOnHashSets()
//    performIntersection()
//    performDifference()
    checkSubset()
}

private fun first() {
    /**
     * hashset defined with initial capacity and load factor
    // val hashSet: HashSet<Int> = HashSet(9, 0.75f)


     * alternately we can define it as
     * HashSet defined without any capacity and load factor
     * By default,
     * the capacity of the hash set will be 16
     * the load factor will be 0.75
     */
    val evenNumber: HashSet<Int> = HashSet()
    val numbers: HashSet<Int> = HashSet()
    evenNumber.add(2)
    evenNumber.add(4)
    evenNumber.add(6)
    numbers.add(1)
    numbers.addAll(evenNumber)
    numbers.add(5)
    println(numbers)
}

private fun second() {
    val numbers: MutableSet<Int> = hashSetOf(1, 2, 3, 4, 6, 8)
    val x = numbers.remove(6)
    println("Is 6 removed: $x")
    println("Hashset: $numbers")

    // Calling Iterator method
    val iterate: MutableIterator<Int> = numbers.iterator()
    print("HashSet using iterator(): ")
    while (iterate.hasNext()) {
        print(iterate.next())
        print(", ")
    }
}

private fun unionOnHashSets() {
    val evenNumbers: HashSet<Int> = HashSet()
    evenNumbers.add(2)
    evenNumbers.add(4)
    evenNumbers.add(6)
    evenNumbers.add(8)
    println("Even numbers: $evenNumbers")

    val numbers: HashSet<Int> = HashSet()
    numbers.add(5)
    numbers.add(8)
    numbers.add(57)
    numbers.add(6)
    println("Numbers: $numbers")

    numbers.addAll(evenNumbers)
    println("union: $numbers")
}

private fun performIntersection() {
    val primeNumbers = HashSet<Int>()
    primeNumbers.add(2)
    primeNumbers.add(3)
    primeNumbers.add(7)
    primeNumbers.add(13)
    println("HashSet1: $primeNumbers")

    val evenNumbers = HashSet<Int>()
    evenNumbers.add(2)
    evenNumbers.add(6)
    evenNumbers.add(5)
    evenNumbers.add(4)
    println("HashSet2: $evenNumbers")

    primeNumbers.retainAll(evenNumbers)
    println("Intersection: $primeNumbers")
}

private fun performDifference() {
    val primeNumbers = HashSet<Int>()
    primeNumbers.add(2)
    primeNumbers.add(3)
    primeNumbers.add(5)
    println("HashSet1: $primeNumbers")

    val oddNumbers = HashSet<Int>()
    oddNumbers.add(1)
    oddNumbers.add(3)
    oddNumbers.add(5)
    println("HashSet2: $oddNumbers")

    primeNumbers.removeAll(oddNumbers)
    println("Difference: $primeNumbers")
}

private fun checkSubset() {
    val set1: HashSet<String> = hashSetOf("One", "Two", "Three", "Four", "Five", "Six")
    println("Set 1: $set1")

    val set2: HashSet<String> = hashSetOf("Two", "Five", "Seven", "Three")
    println("Set 2: $set2")

    val set3: HashSet<String> = hashSetOf("Six", "One", "Three")
    println("Set 3: $set3 ")

    println("Is set 2 a subset of set 1 : ${set1.containsAll(set2)}")
    println("Is set 3 a subset of set 1 : ${set1.containsAll(set3)}")
    println("Is set 1 a subset of set 3 : ${set3.containsAll(set1)}")
    println("Is set 1 a subset of set 1 : ${set1.containsAll(set1)}")

}