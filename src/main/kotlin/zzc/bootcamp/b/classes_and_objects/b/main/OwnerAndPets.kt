package zzc.bootcamp.b.classes_and_objects.b.main

data class Pet(val name: String, val breed: String) {
    constructor(name: String, breed: String, owner: Person) : this(name, breed) {
        owner.pets.add(this)
    }
}

class Person(val pets: MutableList<Pet> = mutableListOf())

fun main() {
    val mudit = Person()
    val kalpesh = Person()
    Pet("Bruno", "Labrador", mudit)
    Pet("Sheku", "German Shepherd", kalpesh)
    Pet("Biscut", "Pitbull", mudit)
    Pet("bacchu", "pug", kalpesh)
    Pet("chotu", "pomerian", mudit)

    mudit.pets.forEach(::println)
    kalpesh.pets.forEach(::println)


}