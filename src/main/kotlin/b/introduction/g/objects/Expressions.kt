package b.introduction.g.objects

data class SendObject(val x: String, val y: String)

fun main() {
    println(Hello)

    fun getObject(): Any = object {
        val c = "Hello"
    }

//    println(getObject().c) can't access 'c' as the type is Any

   val obj = object : Interface {
       override fun doMoreWork() {
           TODO("Not yet implemented")
       }
   }

    val sendableObject = obj.sendObject()
    if (sendableObject is SendObject) {
        println("x: ${sendableObject.x}, y: ${sendableObject.y}")
    }


    val first: Interface = object: Interface, Abstract() {
        override fun doSomeWork() {
            TODO("Not yet implemented")
        }

        override fun doMoreWork() {
            TODO("Not yet implemented")
        }
    }

//    println(first.abstract)  Can't access as the inferred type is Interface
    println(first.interfacee)

    val second = object : Abstract() {

        override fun doSomeWork() {
            TODO("Not yet implemented")
        }
    }

    println(MyObject)


}

object MyObject

abstract class Abstract {

    val abstract: String = "Abstract"
    open fun doWork() {
    }
    abstract fun doSomeWork()
}

interface Interface {
    val interfacee: String
        get() = "Interface"

    fun sayHello() {
        println("Say Hello")
    }

    fun sendObject() =  object {
        val x = "first"
        val y = "second"
    }
   fun doMoreWork()

}
val x = Hello.interfacee

data object Hello: Interface {
    override fun doMoreWork() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "Object "
    }

//    Data object cannot have a custom implementation of 'equals' or 'hashCode'
//    override fun hashCode(): Int {
//        return super.hashCode()
//    }
}



