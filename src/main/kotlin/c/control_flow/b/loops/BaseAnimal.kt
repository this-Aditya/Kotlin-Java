package c.control_flow.b.loops

//class Base {
//}

//fun main() {
//    val cakes = listOf("Chocolate, Strawberry, Vanilla")
//    for (cake in cakes) {
//        println(cake)
//    }
//    var cakesEaten = 0
//    var cakesBaked = 0
//
//    while (cakesEaten < 5) {
//        eatACake()
//        cakesEaten++
//    }
//
//    do {
//        bakeACake()
//        cakesBaked++
//    } while (cakesBaked < cakesEaten)

//}

fun eatACake() = println("eat a cake")
fun bakeACake() = println("bake a cake")

class BaseAnimal(val name: String)

class Zoo(val animals: List<BaseAnimal>) {

    operator fun iterator() = CustomIterator()

    inner class CustomIterator() : Iterator<BaseAnimal> {
        var index = 0

        override fun hasNext(): Boolean {
            return index <= animals.size
        }

        override fun next(): BaseAnimal {
            if (!hasNext()) throw NoSuchElementException("No element next")
            return animals[index++]
        }
    }
}

fun main() {
    val zoo = Zoo(listOf(BaseAnimal("Lion"), BaseAnimal("Tiger"), BaseAnimal("Elephant"), BaseAnimal("Girrafe"), BaseAnimal("Bear")))
    for (i in zoo.animals) {
        println(i.name)
    }
}