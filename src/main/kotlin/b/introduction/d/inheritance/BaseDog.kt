package b.introduction.d.inheritance

open class BaseDog {
    init {
        println("INIT: Dog")
    }
    open fun sayHello() {
        println("Wow, Wow")
    }
}

class Yokshire(): BaseDog() {
    init {
        println("INIT: Yokshire")
    }
    override fun sayHello() {
        println("Wif Wif")
    }
}

open class Tiger(private val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says, grhhh!")
    }
}

class SiberianTiger(): Tiger("Sibera")


open class Lion(val name: String, val origin: String) {
fun sayHello() {
    println("$name, the lion from $origin says: graoh!")
}
}

class Asiatic(name: String) : Lion(name = name, origin = "India")


fun main() {
//    val dog: BaseDog = Yokshire()
//    dog.sayHello()

//    val tiger: Tiger = SiberianTiger()
//    tiger.sayHello()

    val lion = Asiatic("Rufo")
    lion.sayHello()

}