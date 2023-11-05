package l.generics

class Consumer<in T> {

    private val items: MutableList<T> = mutableListOf<T>()
    fun consume(item: T) = items.add(item)
    fun size(): Int = items.size
}

private fun useConsumer(star: Consumer<*>) {

    // Cannot consume anything because
    // lower bound is not supported in Kotlin and T is unknown.
//    star.consume(Pet("7"))               // Error: Type mismatch.
//    Required: Nothing
//    Found:Pet

    // Can use T-independent functions and properties.
    star.size()                       // OK
}

