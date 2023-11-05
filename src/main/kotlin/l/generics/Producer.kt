package l.generics

// Covariance without Upper Bound

/**

class Producer<out T> {
    private val items: List<T> = listOf<T>()
    fun produce(): T = items.last()
    fun size() = items.size
}

fun useProducer(pet: Producer<*>) {
    // * indicates T is Unknown, we are not interested in the functions returning or consuming T
    // Below function produces Any, as it doesn't know the specific type of T
    val anyTypeNull: Any? = pet.produce()

//    anyTypeNull.cutenessIndex
//    A pet is not guaranteed. Star mean we can't use the T dependent functions and properties...

        // But 'T' independent functions and properties can be used.
    pet.size()

}
*/

data class Pet(val cutenessIndex: String)

class Producer<out T: Pet> {

    private val pets: List<T> = listOf<T>()
    fun produce(): T = pets.last()
}

fun useProducer(star: Producer<*>){

    // Even though we use * here, T is known to be at least a Pet
    // because it's an upper bound at the declaration site.
    // So, Pet is guaranteed.
    val pet: Pet = star.produce()

    pet.cutenessIndex
}
















