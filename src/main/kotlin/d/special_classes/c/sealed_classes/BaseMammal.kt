package d.special_classes.c.sealed_classes

sealed class BaseMammal(val name: String)
class Cat(catName: String) : BaseMammal(catName)
class Human(humanName: String, val profession: String) : BaseMammal(humanName)

fun greetMammal(mammal: BaseMammal) {
    println(
        when (mammal) {
            is Human -> "Hi ${mammal.name}. You are an ${mammal.profession}"
            is Cat -> "Hi ${mammal.name}"
        }
    )
}


fun main() {
    val human = Human("John", "Actor")
    val cat = Cat("Kitty")
    greetMammal(human)
    greetMammal(cat)
}